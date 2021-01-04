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
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends BdBaseModel {
    private CustomMessageListener ble;
    private AlaGuessQuesData blf;
    private AlaGuessQuesData blg;
    private InterfaceC0183c blh;
    private b blk;
    private a bll;
    private String bli = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String blj = "https://quanmin.baidu.com/pubshow/subject/answer";
    private volatile int blm = -1;
    private final Object mLock = new Object();
    private HttpMessageListener bln = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (c.this.blk != null) {
                        c.this.blk.onFailure(httpResponsedMessage.getError());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (c.this.blk != null) {
                    c.this.blk.d(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow());
                }
            }
        }
    };
    private HttpMessageListener blo = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || c.this.getErrorCode() != 0) {
                c.this.bll.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (c.this.bll != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    c.this.bll.LM();
                } else {
                    c.this.bll.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void LM();

        void onFailure(int i, String str);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void d(int i, String str, boolean z);

        void onFailure(int i);
    }

    /* renamed from: com.baidu.live.guess.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0183c {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public c(InterfaceC0183c interfaceC0183c) {
        this.blh = interfaceC0183c;
    }

    public void LI() {
        if (this.ble == null) {
            this.ble = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.c.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && c.this.LL() != -1 && c.this.LL() != 2) {
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
                                        c.this.c(jSONObject2, parseLong);
                                        c.this.blh.b(c.this.blg);
                                    } else if (TextUtils.equals(optString, "subject_mi_info")) {
                                        c.this.b(jSONObject2, parseLong);
                                        c.this.blh.a(c.this.blf);
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
        MessageManager.getInstance().registerListener(this.ble);
        MessageManager.getInstance().registerListener(this.bln);
        MessageManager.getInstance().registerListener(this.blo);
        LK();
        LJ();
    }

    private void LJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.blj);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void LK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bli);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void eY(int i) {
        this.blm = i;
    }

    public int LL() {
        return this.blm;
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
    public void b(JSONObject jSONObject, long j) {
        if (this.blf == null) {
            this.blf = new AlaGuessQuesData();
        }
        this.blf.setRoomId(j);
        this.blf.setQuesContent(jSONObject.optString("ques_content"));
        this.blf.setQuesId(jSONObject.optLong("ques_id"));
        this.blf.setAnswerInfo(jSONObject.optString("answer"));
        this.blf.setAnswerTime(jSONObject.optInt("answer_time"));
        this.blf.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.blf.setFirstOpt(split[0]);
        this.blf.setSecondOpt(split[1]);
        this.blf.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.blf.setContentType("subject_mi_info");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, long j) {
        if (this.blg == null) {
            this.blg = new AlaGuessQuesData();
        }
        this.blg.setRoomId(j);
        this.blg.setAnswer(jSONObject.optInt("answer"));
        this.blg.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.blg.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.blg.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.blg.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.blg.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.blg.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.blg.setFirstOpt(split[0]);
        this.blg.setSecondOpt(split[1]);
        this.blg.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.blg.setContentType(AlaGuessQuesData.ANSWER_INFO);
    }

    public void LE() {
        this.blm = -1;
    }

    public void onDestroy() {
        if (this.blf != null) {
            this.blf.reset();
        }
        if (this.blg != null) {
            this.blg.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.ble);
        MessageManager.getInstance().unRegisterListener(this.bln);
        MessageManager.getInstance().unRegisterListener(this.blo);
        MessageManager.getInstance().unRegisterTask(1021215);
        MessageManager.getInstance().unRegisterTask(1021218);
    }

    public void a(long j, int i, b bVar) {
        this.blk = bVar;
        com.baidu.live.guess.http.b bVar2 = new com.baidu.live.guess.http.b();
        bVar2.setUserId(j);
        bVar2.eZ(i);
        MessageManager.getInstance().sendMessage(bVar2);
    }

    public void a(long j, long j2, int i, a aVar) {
        this.bll = aVar;
        com.baidu.live.guess.http.a aVar2 = new com.baidu.live.guess.http.a();
        aVar2.setUserId(j);
        aVar2.setAnswer(i);
        aVar2.setQuesId(j2);
        aVar2.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(aVar2);
    }
}
