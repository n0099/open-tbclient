package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bpd;
    private HashSet<String> bpe = new HashSet<>();
    private HashSet<String> bpf = new HashSet<>();
    private HashSet<String> bpg = new HashSet<>();
    private HashSet<String> bph = new HashSet<>();
    private HashMap<String, String> bpi = new HashMap<>();
    private HashMap<String, String> bpj = new HashMap<>();
    private HashMap<String, g> bpk = new HashMap<>();
    private HashSet<String> bpl = new HashSet<>();
    private int bpm;
    private int bpn;
    private int bpo;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d SU() {
        if (bpd == null) {
            synchronized (d.class) {
                if (bpd == null) {
                    bpd = new d();
                }
            }
        }
        return bpd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpm = 360000;
        s Tr = s.Tr();
        this.bpn = Tr.getInt("ubc_data_expire_time", 259200000);
        this.bpo = Tr.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.SS().a(this.bpe, this.bph, this.bpf, this.bpg, this.bpi, this.bpj, this.bpk, this.bpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpe.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bph.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        if (q.Tq().Fo()) {
            return true;
        }
        return this.bpf.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jJ(String str) {
        return this.bpg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jK(String str) {
        return this.bpj.containsKey(str) ? this.bpj.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SV() {
        return this.bpm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fn(int i) {
        if (i * 60000 >= this.bpm) {
            this.bpm = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SW() {
        return this.bpn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpo;
    }

    public int jL(String str) {
        if (TextUtils.isEmpty(str) || !this.bpi.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpi.get(str));
    }

    public boolean jM(String str) {
        if (this.bpk == null || !this.bpk.containsKey(str)) {
            return false;
        }
        return this.bpk.get(str).SY();
    }

    public boolean jN(String str) {
        if (this.bpk == null || !this.bpk.containsKey(str)) {
            return false;
        }
        return this.bpk.get(str).SZ();
    }

    public String jO(String str) {
        return (TextUtils.isEmpty(str) || !this.bpl.contains(str)) ? "0" : "1";
    }
}
