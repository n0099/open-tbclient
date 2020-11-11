package com.baidu.live.guess;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.data.AlaGuessQuesData;
import com.baidu.live.guess.http.GuessUploadAnswerResponseMessage;
import com.baidu.live.guess.http.GuessVoucherHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private CustomMessageListener bgW;
    private AlaGuessQuesData bgX;
    private AlaGuessQuesData bgY;
    private InterfaceC0186c bgZ;
    private b bhc;
    private a bhd;
    private String bha = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String bhb = "https://quanmin.baidu.com/pubshow/subject/answer";
    private volatile int bhe = -1;
    private final Object mLock = new Object();
    private HttpMessageListener bhf = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (c.this.bhc != null) {
                        c.this.bhc.onFailure(httpResponsedMessage.getError());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (c.this.bhc != null) {
                    c.this.bhc.d(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow());
                }
            }
        }
    };
    private HttpMessageListener bhg = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || c.this.getErrorCode() != 0) {
                c.this.bhd.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (c.this.bhd != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    c.this.bhd.KW();
                } else {
                    c.this.bhd.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void KW();

        void onFailure(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void d(int i, String str, boolean z);

        void onFailure(int i);
    }

    /* renamed from: com.baidu.live.guess.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0186c {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public c(InterfaceC0186c interfaceC0186c) {
        this.bgZ = interfaceC0186c;
    }

    public void KS() {
        if (this.bgW == null) {
            this.bgW = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.c.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && c.this.KV() != -1 && c.this.KV() != 2) {
                            for (String str : list) {
                                try {
                                    jSONObject = new JSONObject(str);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (!jSONObject.optString("room_id").equals("")) {
                                    long parseLong = Long.parseLong(jSONObject.optString("room_id"));
                                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("content"));
                                    String optString = jSONObject2.optString("content_type");
                                    if (TextUtils.equals(optString, AlaGuessQuesData.ANSWER_INFO)) {
                                        c.this.b(jSONObject2, parseLong);
                                        c.this.bgZ.b(c.this.bgY);
                                    } else if (TextUtils.equals(optString, "subject_mi_info")) {
                                        c.this.a(jSONObject2, parseLong);
                                        c.this.bgZ.a(c.this.bgX);
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            };
        }
        registerListener(this.bgW);
        registerListener(this.bhf);
        registerListener(this.bhg);
        KU();
        KT();
    }

    private void KT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.bhb);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void KU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bha);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void eI(int i) {
        this.bhe = i;
    }

    public int KV() {
        return this.bhe;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, long j) {
        if (this.bgX == null) {
            this.bgX = new AlaGuessQuesData();
        }
        this.bgX.setRoomId(j);
        this.bgX.setQuesContent(jSONObject.optString("ques_content"));
        this.bgX.setQuesId(jSONObject.optLong("ques_id"));
        this.bgX.setAnswerInfo(jSONObject.optString(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bgX.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bgX.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bgX.setFirstOpt(split[0]);
        this.bgX.setSecondOpt(split[1]);
        this.bgX.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bgX.setContentType("subject_mi_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, long j) {
        if (this.bgY == null) {
            this.bgY = new AlaGuessQuesData();
        }
        this.bgY.setRoomId(j);
        this.bgY.setAnswer(jSONObject.optInt(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bgY.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.bgY.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.bgY.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.bgY.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.bgY.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.bgY.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bgY.setFirstOpt(split[0]);
        this.bgY.setSecondOpt(split[1]);
        this.bgY.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.bgY.setContentType(AlaGuessQuesData.ANSWER_INFO);
    }

    public void KN() {
        this.bhe = -1;
    }

    public void onDestroy() {
        if (this.bgX != null) {
            this.bgX.reset();
        }
        if (this.bgY != null) {
            this.bgY.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.bgW);
        MessageManager.getInstance().unRegisterListener(this.bhf);
        MessageManager.getInstance().unRegisterTask(1021215);
    }

    public void a(long j, int i, b bVar) {
        this.bhc = bVar;
        com.baidu.live.guess.http.b bVar2 = new com.baidu.live.guess.http.b();
        bVar2.setUserId(j);
        bVar2.eJ(i);
        MessageManager.getInstance().sendMessage(bVar2);
    }

    public void a(long j, long j2, int i, a aVar) {
        this.bhd = aVar;
        com.baidu.live.guess.http.a aVar2 = new com.baidu.live.guess.http.a();
        aVar2.setUserId(j);
        aVar2.setAnswer(i);
        aVar2.setQuesId(j2);
        aVar2.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(aVar2);
    }
}
