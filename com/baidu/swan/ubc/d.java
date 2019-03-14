package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bpa;
    private HashSet<String> bpb = new HashSet<>();
    private HashSet<String> bpc = new HashSet<>();
    private HashSet<String> bpd = new HashSet<>();
    private HashSet<String> bpe = new HashSet<>();
    private HashMap<String, String> bpf = new HashMap<>();
    private HashMap<String, String> bpg = new HashMap<>();
    private HashMap<String, g> bph = new HashMap<>();
    private HashSet<String> bpi = new HashSet<>();
    private int bpj;
    private int bpk;
    private int bpl;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d SW() {
        if (bpa == null) {
            synchronized (d.class) {
                if (bpa == null) {
                    bpa = new d();
                }
            }
        }
        return bpa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpj = 360000;
        s Tt = s.Tt();
        this.bpk = Tt.getInt("ubc_data_expire_time", 259200000);
        this.bpl = Tt.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.SU().a(this.bpb, this.bpe, this.bpc, this.bpd, this.bpf, this.bpg, this.bph, this.bpi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpb.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bpe.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jH(String str) {
        if (q.Ts().Fq()) {
            return true;
        }
        return this.bpc.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        return this.bpd.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jJ(String str) {
        return this.bpg.containsKey(str) ? this.bpg.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fo(int i) {
        if (i * 60000 >= this.bpj) {
            this.bpj = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SY() {
        return this.bpk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SZ() {
        return this.bpl;
    }

    public int jK(String str) {
        if (TextUtils.isEmpty(str) || !this.bpf.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpf.get(str));
    }

    public boolean jL(String str) {
        if (this.bph == null || !this.bph.containsKey(str)) {
            return false;
        }
        return this.bph.get(str).Ta();
    }

    public boolean jM(String str) {
        if (this.bph == null || !this.bph.containsKey(str)) {
            return false;
        }
        return this.bph.get(str).Tb();
    }

    public String jN(String str) {
        return (TextUtils.isEmpty(str) || !this.bpi.contains(str)) ? "0" : "1";
    }
}
