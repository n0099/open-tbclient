package com.baidu.adp.lib.webSocket;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
/* loaded from: classes.dex */
public class am {
    private String pp;
    private int qd;
    private int qe;
    private boolean qf;
    private boolean qg;
    private int qh;
    private int qi;
    private boolean qj;
    private boolean qk;

    public am() {
        this.pp = null;
        this.qd = AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        this.qe = AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
        this.qf = false;
        this.qg = true;
        this.qh = 30000;
        this.qi = 30000;
        this.qj = true;
        this.qk = true;
        this.pp = null;
    }

    public am(am amVar) {
        this.pp = null;
        this.qd = amVar.qd;
        this.qe = amVar.qe;
        this.qf = amVar.qf;
        this.qg = amVar.qg;
        this.qh = amVar.qh;
        this.qi = amVar.qi;
        this.qj = amVar.qj;
        this.qk = amVar.qk;
        this.pp = amVar.pp;
    }

    public boolean gk() {
        return this.qf;
    }

    public int gl() {
        return this.qd;
    }

    public int gm() {
        return this.qe;
    }

    public boolean getTcpNoDelay() {
        return this.qg;
    }

    public int gn() {
        return this.qh;
    }

    public int go() {
        return this.qi;
    }

    public boolean gp() {
        return this.qj;
    }

    public boolean gq() {
        return this.qk;
    }

    public String gr() {
        return this.pp;
    }

    public void aK(String str) {
        this.pp = str;
    }
}
