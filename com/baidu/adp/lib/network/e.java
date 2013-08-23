package com.baidu.adp.lib.network;

import com.baidu.browser.core.util.BdUtil;
/* loaded from: classes.dex */
public class e {
    public String b;
    public byte[] d;

    /* renamed from: a  reason: collision with root package name */
    public int f446a = 0;
    public f c = new f();
    public String e = BdUtil.UTF8;

    public String toString() {
        try {
            return new String(this.d, this.e);
        } catch (Exception e) {
            return "";
        }
    }
}
