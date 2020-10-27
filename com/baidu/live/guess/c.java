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
    private CustomMessageListener bfC;
    private AlaGuessQuesData bfD;
    private AlaGuessQuesData bfE;
    private InterfaceC0184c bfF;
    private b bfI;
    private a bfJ;
    private String bfG = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String bfH = "https://quanmin.baidu.com/pubshow/subject/answer";
    private volatile int bfK = -1;
    private final Object mLock = new Object();
    private HttpMessageListener bfL = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (c.this.bfI != null) {
                        c.this.bfI.onFailure(httpResponsedMessage.getError());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (c.this.bfI != null) {
                    c.this.bfI.d(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow());
                }
            }
        }
    };
    private HttpMessageListener bfM = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || c.this.getErrorCode() != 0) {
                c.this.bfJ.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (c.this.bfJ != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    c.this.bfJ.Kw();
                } else {
                    c.this.bfJ.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Kw();

        void onFailure(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void d(int i, String str, boolean z);

        void onFailure(int i);
    }

    /* renamed from: com.baidu.live.guess.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0184c {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public c(InterfaceC0184c interfaceC0184c) {
        this.bfF = interfaceC0184c;
    }

    public void Ks() {
        if (this.bfC == null) {
            this.bfC = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.c.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && c.this.Kv() != -1 && c.this.Kv() != 2) {
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
                                        c.this.bfF.b(c.this.bfE);
                                    } else if (TextUtils.equals(optString, "subject_mi_info")) {
                                        c.this.a(jSONObject2, parseLong);
                                        c.this.bfF.a(c.this.bfD);
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
        registerListener(this.bfC);
        registerListener(this.bfL);
        registerListener(this.bfM);
        Ku();
        Kt();
    }

    private void Kt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.bfH);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Ku() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bfG);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void eI(int i) {
        this.bfK = i;
    }

    public int Kv() {
        return this.bfK;
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
        if (this.bfD == null) {
            this.bfD = new AlaGuessQuesData();
        }
        this.bfD.setRoomId(j);
        this.bfD.setQuesContent(jSONObject.optString("ques_content"));
        this.bfD.setQuesId(jSONObject.optLong("ques_id"));
        this.bfD.setAnswerInfo(jSONObject.optString(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bfD.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bfD.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bfD.setFirstOpt(split[0]);
        this.bfD.setSecondOpt(split[1]);
        this.bfD.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bfD.setContentType("subject_mi_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, long j) {
        if (this.bfE == null) {
            this.bfE = new AlaGuessQuesData();
        }
        this.bfE.setRoomId(j);
        this.bfE.setAnswer(jSONObject.optInt(UgcUBCUtils.QUESTION_REPLY_PAGE));
        this.bfE.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.bfE.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.bfE.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.bfE.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.bfE.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.bfE.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bfE.setFirstOpt(split[0]);
        this.bfE.setSecondOpt(split[1]);
        this.bfE.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.bfE.setContentType(AlaGuessQuesData.ANSWER_INFO);
    }

    public void Kn() {
        this.bfK = -1;
    }

    public void onDestroy() {
        if (this.bfD != null) {
            this.bfD.reset();
        }
        if (this.bfE != null) {
            this.bfE.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.bfC);
        MessageManager.getInstance().unRegisterListener(this.bfL);
        MessageManager.getInstance().unRegisterTask(1021215);
    }

    public void a(long j, int i, b bVar) {
        this.bfI = bVar;
        com.baidu.live.guess.http.b bVar2 = new com.baidu.live.guess.http.b();
        bVar2.setUserId(j);
        bVar2.eJ(i);
        MessageManager.getInstance().sendMessage(bVar2);
    }

    public void a(long j, long j2, int i, a aVar) {
        this.bfJ = aVar;
        com.baidu.live.guess.http.a aVar2 = new com.baidu.live.guess.http.a();
        aVar2.setUserId(j);
        aVar2.setAnswer(i);
        aVar2.setQuesId(j2);
        aVar2.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(aVar2);
    }
}
