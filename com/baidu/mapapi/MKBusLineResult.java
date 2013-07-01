package com.baidu.mapapi;
/* loaded from: classes.dex */
public class MKBusLineResult {

    /* renamed from: a  reason: collision with root package name */
    private String f506a;
    private String b;
    private int c;
    private String d;
    private String e;
    private MKRoute f = new MKRoute();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, int i) {
        this.f506a = str;
        this.b = str2;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.e = str;
    }

    public String getBusCompany() {
        return this.f506a;
    }

    public String getBusName() {
        return this.b;
    }

    public MKRoute getBusRoute() {
        return this.f;
    }

    public String getEndTime() {
        return this.e;
    }

    public String getStartTime() {
        return this.d;
    }

    public MKStep getStation(int i) {
        return this.f.getStep(i);
    }

    public int isMonTicket() {
        return this.c;
    }
}
