package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = g.DEBUG;
    private static volatile d boZ;
    private HashSet<String> bpa = new HashSet<>();
    private HashSet<String> bpb = new HashSet<>();
    private HashSet<String> bpc = new HashSet<>();
    private HashSet<String> bpd = new HashSet<>();
    private HashMap<String, String> bpe = new HashMap<>();
    private HashMap<String, String> bpf = new HashMap<>();
    private HashMap<String, h> bpg = new HashMap<>();
    private HashSet<String> bph = new HashSet<>();
    private int bpi;
    private int bpj;
    private int bpk;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d SW() {
        if (boZ == null) {
            synchronized (d.class) {
                if (boZ == null) {
                    boZ = new d();
                }
            }
        }
        return boZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpi = 360000;
        t Tt = t.Tt();
        this.bpj = Tt.getInt("ubc_data_expire_time", 259200000);
        this.bpk = Tt.getInt("ubc_database_limit", 4000);
        cVar.SU().a(this.bpa, this.bpd, this.bpb, this.bpc, this.bpe, this.bpf, this.bpg, this.bph);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpa.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bpd.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jH(String str) {
        if (r.Ts().Fq()) {
            return true;
        }
        return this.bpb.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        return this.bpc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jJ(String str) {
        return this.bpf.containsKey(str) ? this.bpf.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fo(int i) {
        if (i * 60000 >= this.bpi) {
            this.bpi = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SY() {
        return this.bpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SZ() {
        return this.bpk;
    }

    public int jK(String str) {
        if (TextUtils.isEmpty(str) || !this.bpe.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpe.get(str));
    }

    public boolean jL(String str) {
        if (this.bpg == null || !this.bpg.containsKey(str)) {
            return false;
        }
        return this.bpg.get(str).Ta();
    }

    public boolean jM(String str) {
        if (this.bpg == null || !this.bpg.containsKey(str)) {
            return false;
        }
        return this.bpg.get(str).Tb();
    }

    public String jN(String str) {
        return (TextUtils.isEmpty(str) || !this.bph.contains(str)) ? "0" : "1";
    }
}
