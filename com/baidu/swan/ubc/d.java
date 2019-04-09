package com.baidu.swan.ubc;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bpe;
    private HashSet<String> bpf = new HashSet<>();
    private HashSet<String> bpg = new HashSet<>();
    private HashSet<String> bph = new HashSet<>();
    private HashSet<String> bpi = new HashSet<>();
    private HashMap<String, String> bpj = new HashMap<>();
    private HashMap<String, String> bpk = new HashMap<>();
    private HashMap<String, g> bpl = new HashMap<>();
    private HashSet<String> bpm = new HashSet<>();
    private int bpn;
    private int bpo;
    private int bpp;
    private Context mContext;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d SU() {
        if (bpe == null) {
            synchronized (d.class) {
                if (bpe == null) {
                    bpe = new d();
                }
            }
        }
        return bpe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, Context context) {
        this.mContext = context;
        this.bpn = 360000;
        s Tr = s.Tr();
        this.bpo = Tr.getInt("ubc_data_expire_time", 259200000);
        this.bpp = Tr.getInt("ubc_database_limit", UIMsg.m_AppUI.MSG_APP_SAVESCREEN);
        cVar.SS().a(this.bpf, this.bpi, this.bpg, this.bph, this.bpj, this.bpk, this.bpl, this.bpm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(String str, int i) {
        if (this.bpf.contains(str)) {
            return false;
        }
        return ((i & 16) == 0 && (i & 32) == 0) || this.bpi.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jI(String str) {
        if (q.Tq().Fo()) {
            return true;
        }
        return this.bpg.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean jJ(String str) {
        return this.bph.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String jK(String str) {
        return this.bpk.containsKey(str) ? this.bpk.get(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SV() {
        return this.bpn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fn(int i) {
        if (i * 60000 >= this.bpn) {
            this.bpn = i * 60000;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SW() {
        return this.bpo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int SX() {
        return this.bpp;
    }

    public int jL(String str) {
        if (TextUtils.isEmpty(str) || !this.bpj.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.bpj.get(str));
    }

    public boolean jM(String str) {
        if (this.bpl == null || !this.bpl.containsKey(str)) {
            return false;
        }
        return this.bpl.get(str).SY();
    }

    public boolean jN(String str) {
        if (this.bpl == null || !this.bpl.containsKey(str)) {
            return false;
        }
        return this.bpl.get(str).SZ();
    }

    public String jO(String str) {
        return (TextUtils.isEmpty(str) || !this.bpm.contains(str)) ? "0" : "1";
    }
}
