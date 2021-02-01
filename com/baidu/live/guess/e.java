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
import com.baidu.live.data.n;
import com.baidu.live.data.o;
import com.baidu.live.guess.http.GuessGroupInfoHttpResponseMessage;
import com.baidu.live.guess.http.GuessResultHttpResponseMessage;
import com.baidu.live.guess.http.GuessUploadAnswerResponseMessage;
import com.baidu.live.guess.http.GuessVoucherHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private InterfaceC0175e bjA;
    private d bjF;
    private a bjG;
    private b bjI;
    private c bjJ;
    private CustomMessageListener bjx;
    private AlaGuessQuesData bjy;
    private AlaGuessQuesData bjz;
    private String bjB = "https://quanmin.baidu.com/pubshow/task/Getquizticket";
    private String bjC = "https://quanmin.baidu.com/pubshow/subject/answer";
    private String bjD = "https://quanmin.baidu.com/pubshow/team/teaminfo";
    private String bjE = "https://quanmin.baidu.com/pubshow/subject/getanswerresult";
    private volatile int bjH = -1;
    private HttpMessageListener bjK = new HttpMessageListener(1021215) { // from class: com.baidu.live.guess.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuessVoucherHttpResponseMessage)) {
                int error = httpResponsedMessage.getError();
                if (httpResponsedMessage.getStatusCode() != 200 || error != 0) {
                    if (e.this.bjF != null) {
                        e.this.bjF.onFailure(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                GuessVoucherHttpResponseMessage guessVoucherHttpResponseMessage = (GuessVoucherHttpResponseMessage) httpResponsedMessage;
                if (e.this.bjF != null) {
                    e.this.bjF.a(guessVoucherHttpResponseMessage.getVoucherNum(), guessVoucherHttpResponseMessage.getTaskUrl(), guessVoucherHttpResponseMessage.isFollow(), guessVoucherHttpResponseMessage.getDoubleTicketNumber());
                }
            }
        }
    };
    private HttpMessageListener bjL = new HttpMessageListener(1021218) { // from class: com.baidu.live.guess.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessUploadAnswerResponseMessage guessUploadAnswerResponseMessage = (GuessUploadAnswerResponseMessage) httpResponsedMessage;
            if (guessUploadAnswerResponseMessage.getStatusCode() != 200 || e.this.getErrorCode() != 0) {
                e.this.bjG.onFailure(httpResponsedMessage.getStatusCode(), httpResponsedMessage.getErrorString());
            } else if (e.this.bjG != null) {
                if (guessUploadAnswerResponseMessage.getStatus() == 0) {
                    e.this.bjG.Jm();
                } else {
                    e.this.bjG.onFailure(guessUploadAnswerResponseMessage.getStatus(), guessUploadAnswerResponseMessage.getMsg());
                }
            }
        }
    };
    private HttpMessageListener bjM = new HttpMessageListener(1021237) { // from class: com.baidu.live.guess.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessGroupInfoHttpResponseMessage guessGroupInfoHttpResponseMessage = (GuessGroupInfoHttpResponseMessage) httpResponsedMessage;
            if (guessGroupInfoHttpResponseMessage.getStatusCode() != 200 || e.this.getErrorCode() != 0) {
                if (e.this.bjI != null) {
                    e.this.bjI.onFailure(guessGroupInfoHttpResponseMessage.getError(), guessGroupInfoHttpResponseMessage.getErrorString());
                }
            } else if (e.this.bjI != null) {
                e.this.bjI.N(guessGroupInfoHttpResponseMessage.getGroupList());
            }
        }
    };
    private HttpMessageListener bjN = new HttpMessageListener(1021239) { // from class: com.baidu.live.guess.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuessResultHttpResponseMessage guessResultHttpResponseMessage = (GuessResultHttpResponseMessage) httpResponsedMessage;
            if (guessResultHttpResponseMessage.getStatusCode() != 200 || e.this.getErrorCode() != 0) {
                if (e.this.bjJ != null) {
                    e.this.bjJ.onFailure(guessResultHttpResponseMessage.getError(), guessResultHttpResponseMessage.getErrorString());
                }
            } else if (e.this.bjJ != null) {
                e.this.bjJ.a(guessResultHttpResponseMessage.Jn());
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void Jm();

        void onFailure(int i, String str);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void N(List<n> list);

        void onFailure(int i, String str);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(o oVar);

        void onFailure(int i, String str);
    }

    /* loaded from: classes11.dex */
    public interface d {
        void a(int i, String str, boolean z, int i2);

        void onFailure(int i, String str);
    }

    /* renamed from: com.baidu.live.guess.e$e  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0175e {
        void a(AlaGuessQuesData alaGuessQuesData);

        void b(AlaGuessQuesData alaGuessQuesData);
    }

    public e(InterfaceC0175e interfaceC0175e) {
        this.bjA = interfaceC0175e;
    }

    public void a(b bVar) {
        this.bjI = bVar;
    }

    public void Jg() {
        if (this.bjx == null) {
            this.bjx = new CustomMessageListener(2913251) { // from class: com.baidu.live.guess.e.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    JSONObject jSONObject;
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        List<String> list = (List) customResponsedMessage.getData();
                        if (list.size() != 0 && e.this.Jl() != -1 && e.this.Jl() != 2) {
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
                                    if (TextUtils.equals(optString, "answer_im_info_three")) {
                                        e.this.c(jSONObject2, parseLong);
                                        e.this.bjA.b(e.this.bjz);
                                    } else if (TextUtils.equals(optString, "subject_im_info_three")) {
                                        e.this.b(jSONObject2, parseLong);
                                        e.this.bjA.a(e.this.bjy);
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
        registerListener(this.bjx);
        registerListener(this.bjK);
        registerListener(this.bjL);
        registerListener(this.bjM);
        registerListener(this.bjN);
        Jk();
        Jj();
        Ji();
        Jh();
    }

    private void Jh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021239, this.bjE);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuessResultHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Ji() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021237, this.bjD);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessGroupInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Jj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021218, this.bjC);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessUploadAnswerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void Jk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021215, this.bjB);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuessVoucherHttpResponseMessage.class);
        tbHttpMessageTask.setRetry(2);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void dx(int i) {
        this.bjH = i;
    }

    public int Jl() {
        return this.bjH;
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
        if (this.bjy == null) {
            this.bjy = new AlaGuessQuesData();
        }
        this.bjy.setRoomId(j);
        this.bjy.setQuesContent(jSONObject.optString("ques_content"));
        this.bjy.setQuesId(jSONObject.optLong("ques_id"));
        this.bjy.setAnswerInfo(jSONObject.optString("answer"));
        this.bjy.setAnswerTime(jSONObject.optInt("answer_time"));
        this.bjy.setAmount(JavaTypesHelper.toInt(jSONObject.optString(LogConfig.LOG_AMOUNT), 0));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bjy.setFirstOpt(split[0]);
        this.bjy.setSecondOpt(split[1]);
        this.bjy.setAnchorId(JavaTypesHelper.toLong(jSONObject.optString("anchor_uid"), 0L));
        this.bjy.setContentType("subject_im_info_three");
        this.bjy.setDoubleTicketImg(jSONObject.optString("double_coupon_img"));
        this.bjy.setDoubleTicketTitle(jSONObject.optString("double_coupon_title"));
        this.bjy.setDoubleTicketContent(jSONObject.optString("double_coupon_content"));
        this.bjy.setDoubleTicketSwitch(jSONObject.optInt("is_double_coupon") == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, long j) {
        if (this.bjz == null) {
            this.bjz = new AlaGuessQuesData();
        }
        this.bjz.setRoomId(j);
        this.bjz.setAnswer(jSONObject.optInt("answer"));
        this.bjz.setTotalNum(JavaTypesHelper.toLong(jSONObject.optString("total_number"), 0L));
        this.bjz.setCorrectNum(JavaTypesHelper.toLong(jSONObject.optString("currect_number"), 0L));
        this.bjz.setCorrectPercent(JavaTypesHelper.toDouble(jSONObject.optString("currect_percent"), 0.0d));
        this.bjz.setAmount(JavaTypesHelper.toLong(jSONObject.optString(LogConfig.LOG_AMOUNT), 0L));
        this.bjz.setAverage(JavaTypesHelper.toFloat(jSONObject.optString("average_amount"), 0.0f));
        this.bjz.setDoubleAverage(JavaTypesHelper.toFloat(jSONObject.optString("double_amount"), 0.0f));
        this.bjz.setQuesContent(jSONObject.optString("ques_content"));
        String[] split = jSONObject.optString("answer_option").split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.bjz.setFirstOpt(split[0]);
        this.bjz.setSecondOpt(split[1]);
        this.bjz.setQuesId(JavaTypesHelper.toLong(jSONObject.optString("ques_id"), 0L));
        this.bjz.setContentType("answer_im_info_three");
    }

    public void IZ() {
        this.bjH = -1;
    }

    public void onDestroy() {
        if (this.bjy != null) {
            this.bjy.reset();
        }
        if (this.bjz != null) {
            this.bjz.reset();
        }
        MessageManager.getInstance().unRegisterListener(this.bjM);
        MessageManager.getInstance().unRegisterListener(this.bjx);
        MessageManager.getInstance().unRegisterListener(this.bjK);
        MessageManager.getInstance().unRegisterTask(1021215);
        MessageManager.getInstance().unRegisterListener(this.bjN);
    }

    public void a(long j, int i, d dVar) {
        this.bjF = dVar;
        com.baidu.live.guess.http.d dVar2 = new com.baidu.live.guess.http.d();
        dVar2.setUserId(ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        dVar2.dy(i);
        MessageManager.getInstance().sendMessage(dVar2);
    }

    public void a(long j, long j2, int i, int i2, a aVar) {
        this.bjG = aVar;
        com.baidu.live.guess.http.c cVar = new com.baidu.live.guess.http.c();
        cVar.setUserId(ExtraParamsManager.getEncryptionUserId(String.valueOf(j)));
        cVar.setAnswer(i);
        cVar.setQuesId(j2);
        cVar.aV(i2);
        cVar.setCuid(TbadkCoreApplication.getInst().getCuid());
        MessageManager.getInstance().sendMessage(cVar);
    }

    public void c(String str, long j, int i) {
        com.baidu.live.guess.http.a aVar = new com.baidu.live.guess.http.a();
        aVar.setUserId(str);
        aVar.setQuesId(j);
        aVar.setIsFirst(i);
        MessageManager.getInstance().sendMessage(aVar);
    }

    public void a(long j, String str, String str2, long j2, c cVar) {
        this.bjJ = cVar;
        com.baidu.live.guess.http.b bVar = new com.baidu.live.guess.http.b();
        bVar.setUserId(str);
        bVar.setQuesId(j);
        bVar.ft(str2);
        bVar.setRoomId(j2);
        MessageManager.getInstance().sendMessage(bVar);
    }
}
