package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGuessQuesData extends BaseData implements Serializable {
    public static final String ANSWER_INFO = "answer_mi_info";
    public static final long LNON = 0;
    public static final int NON = 0;
    public static final String QUESTION_INFO = "";
    private String answerInfo;
    private String firstOpt;
    private String secondOpt;
    private long roomId = 0;
    private long anchorId = 0;
    private long userId = 0;
    private String contentType = "";
    private long quesId = 0;
    private int answerTime = 0;
    private String quesContent = "";
    private long totalNum = 0;
    private long correctNum = 0;
    private double correctPercent = 0.0d;
    private float average = 0.0f;
    private long amount = 0;
    private int answer = 0;
    private int voucherNum = -1;

    public String getFirstOpt() {
        return this.firstOpt;
    }

    public void setFirstOpt(String str) {
        this.firstOpt = str;
    }

    public String getSecondOpt() {
        return this.secondOpt;
    }

    public void setSecondOpt(String str) {
        this.secondOpt = str;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public long getAnchorId() {
        return this.anchorId;
    }

    public void setAnchorId(long j) {
        this.anchorId = j;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public long getQuesId() {
        return this.quesId;
    }

    public void setQuesId(long j) {
        this.quesId = j;
    }

    public int getAnswerTime() {
        return this.answerTime;
    }

    public void setAnswerTime(int i) {
        this.answerTime = i;
    }

    public String getQuesContent() {
        return this.quesContent;
    }

    public void setQuesContent(String str) {
        this.quesContent = str;
    }

    public long getTotalNum() {
        return this.totalNum;
    }

    public void setTotalNum(long j) {
        this.totalNum = j;
    }

    public long getCorrectNum() {
        return this.correctNum;
    }

    public void setCorrectNum(long j) {
        this.correctNum = j;
    }

    public double getCorrectPercent() {
        return this.correctPercent;
    }

    public void setCorrectPercent(double d) {
        this.correctPercent = d;
    }

    public float getAverage() {
        return this.average;
    }

    public void setAverage(float f) {
        this.average = f;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int i) {
        this.answer = i;
    }

    public String getAnswerInfo() {
        return this.answerInfo;
    }

    public void setAnswerInfo(String str) {
        this.answerInfo = str;
    }

    public int getVoucherNum() {
        return this.voucherNum;
    }

    public void setVoucherNum(int i) {
        this.voucherNum = i;
    }

    public void reset() {
        setAmount(0L);
        setAnswerTime(0);
        setAverage(0.0f);
        setCorrectNum(0L);
        setCorrectPercent(0.0d);
        setAnchorId(0L);
        setAverage(0.0f);
        setQuesContent("");
        setQuesId(0L);
        setAnswerTime(0);
        setContentType("");
        setTotalNum(0L);
        setRoomId(0L);
        setAnswer(0);
        setAnswerInfo("");
        setVoucherNum(0);
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
    }
}
