package cn.jiguang.d.h;

import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes3.dex */
final class d extends ThreadLocal<SimpleDateFormat> {
    private String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SimpleDateFormat initialValue() {
        return new SimpleDateFormat(this.a, Locale.ENGLISH);
    }
}
