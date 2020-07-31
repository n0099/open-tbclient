package com.baidu.ar.face.a;

import com.baidu.ar.c.i;
/* loaded from: classes11.dex */
public class e extends com.baidu.ar.c.h {
    private int cQ;
    private int cR;
    private int mCacheSize;
    private String of;
    private String og;
    private String oh;
    private String oi;
    private String oj;
    private String ok;
    private String ol;
    private String om;
    private String on;
    private String oo;
    private float op;
    private float oq;
    private float or;

    public e() {
        super(i.FACE);
        this.op = 0.03f;
        this.oq = 1.0f;
        this.or = -1.0f;
        this.mCacheSize = 5;
    }

    public void E(int i) {
        this.cQ = i;
    }

    public void F(int i) {
        this.cR = i;
    }

    public void V(String str) {
        this.of = str;
    }

    public void W(String str) {
        this.og = str;
    }

    public void X(String str) {
        this.oh = str;
    }

    public void Y(String str) {
        this.oi = str;
    }

    public void Z(String str) {
        this.oj = str;
    }

    public void aa(String str) {
        this.ok = str;
    }

    public void ab(String str) {
        this.ol = str;
    }

    public void ac(String str) {
        this.om = str;
    }

    public void ad(String str) {
        this.on = str;
    }

    public void ae(String str) {
        this.oo = str;
    }

    public int ax() {
        return this.cQ;
    }

    public int ay() {
        return this.cR;
    }

    public String dg() {
        return this.of;
    }

    public String dh() {
        return this.og;
    }

    public String di() {
        return this.oh;
    }

    public String dj() {
        return this.oi;
    }

    public String dk() {
        return this.oj;
    }

    public String dl() {
        return this.ok;
    }

    public String dm() {
        return this.ol;
    }

    public String dn() {
        return this.om;
    }

    /* renamed from: do  reason: not valid java name */
    public String m18do() {
        return this.on;
    }

    public String dp() {
        return this.oo;
    }

    public float dq() {
        return this.op;
    }

    public float dr() {
        return this.oq;
    }

    public float ds() {
        return this.or;
    }

    public void setTrackingMouthThreshold(float f) {
        this.or = f;
    }

    public void setTrackingSmoothAlpha(float f) {
        this.op = f;
    }

    public void setTrackingSmoothThreshold(float f) {
        this.oq = f;
    }
}
