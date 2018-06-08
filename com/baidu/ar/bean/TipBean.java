package com.baidu.ar.bean;

import android.text.TextUtils;
import com.baidu.ar.bean.AttrData;
/* loaded from: classes3.dex */
public class TipBean {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private AttrData.CaseType i;
    private int j;
    private String k;
    private int l;
    private String m;
    private String n;
    private String o;
    private String p;
    private float g = Float.NaN;
    private float h = Float.NaN;
    private int q = 0;
    private int r = 0;

    public TipBean clone(TipBean tipBean) {
        if (!TextUtils.isEmpty(tipBean.getDemarcateTip())) {
            setDemarcateTip(tipBean.getDemarcateTip());
        }
        if (!TextUtils.isEmpty(tipBean.getDemarcateFailedTip())) {
            setDemarcateFailedTip(tipBean.getDemarcateFailedTip());
        }
        if (!TextUtils.isEmpty(tipBean.getHint())) {
            setHint(tipBean.getHint());
        }
        if (!TextUtils.isEmpty(tipBean.getTooFarHint())) {
            setTooFarHint(tipBean.getTooFarHint());
        }
        if (!TextUtils.isEmpty(tipBean.getTooNearHint())) {
            setTooNearHint(tipBean.getTooNearHint());
        }
        if (!TextUtils.isEmpty(tipBean.getNotFindHint())) {
            setNotFindHint(tipBean.getNotFindHint());
        }
        if (Float.compare(tipBean.getFarThreshold(), Float.NaN) != 0) {
            setFarThreshold(tipBean.getFarThreshold());
        }
        if (Float.compare(tipBean.getNearThreshold(), Float.NaN) != 0) {
            setNearThreshold(tipBean.getNearThreshold());
        }
        return this;
    }

    public String getAlignPlane() {
        return this.o;
    }

    public AttrData.CaseType getCaseType() {
        return this.i;
    }

    public String getDemarcateFailedTip() {
        return this.b;
    }

    public String getDemarcateTip() {
        return this.a;
    }

    public float getFarThreshold() {
        return this.g;
    }

    public String getFindPerfectPlane() {
        return this.m;
    }

    public String getHelpUrl() {
        return this.k;
    }

    public int getHelpUrlShowOnce() {
        return this.l;
    }

    public int getHideCaptureGroupImmediately() {
        return this.q;
    }

    public String getHint() {
        return this.c;
    }

    public float getNearThreshold() {
        return this.h;
    }

    public String getNotFindHint() {
        return this.f;
    }

    public String getPlayDesUrl() {
        return this.n;
    }

    public int getShowTipsByCase() {
        return this.r;
    }

    public String getTooFarHint() {
        return this.d;
    }

    public String getTooNearHint() {
        return this.e;
    }

    public String getTrackTargePicPath() {
        return this.p;
    }

    public int getUdtMode() {
        return this.j;
    }

    public void setAlignPlane(String str) {
        this.o = str;
    }

    public void setCaseType(AttrData.CaseType caseType) {
        this.i = caseType;
    }

    public void setDemarcateFailedTip(String str) {
        this.b = str;
    }

    public void setDemarcateTip(String str) {
        this.a = str;
    }

    public void setFarThreshold(float f) {
        this.g = f;
    }

    public void setFindPerfectPlane(String str) {
        this.m = str;
    }

    public void setHelpUrl(String str) {
        this.k = str;
    }

    public void setHelpUrlShowOnce(int i) {
        this.l = i;
    }

    public void setHideCaptureGroupImmediately(int i) {
        this.q = i;
    }

    public void setHint(String str) {
        this.c = str;
    }

    public void setNearThreshold(float f) {
        this.h = f;
    }

    public void setNotFindHint(String str) {
        this.f = str;
    }

    public void setPlayDesUrl(String str) {
        this.n = str;
    }

    public void setShowTipsByCase(int i) {
        this.r = i;
    }

    public void setTooFarHint(String str) {
        this.d = str;
    }

    public void setTooNearHint(String str) {
        this.e = str;
    }

    public void setTrackTargePicPath(String str) {
        this.p = str;
    }

    public void setUdtMode(int i) {
        this.j = i;
    }
}
