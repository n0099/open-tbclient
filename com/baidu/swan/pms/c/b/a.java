package com.baidu.swan.pms.c.b;

import android.text.TextUtils;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.c.a;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.utils.f;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.a> {
    public a(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cO */
    public com.baidu.swan.pms.c.c.a cN(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.db(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ao(com.baidu.swan.pms.c.c.a aVar) {
        this.evO.aqK();
        f fVar = new f();
        Map<String, PMSAppInfo> bcz = com.baidu.swan.pms.database.a.bcx().bcz();
        ArrayList arrayList = new ArrayList();
        for (a.C0545a c0545a : aVar.ewt) {
            if (c0545a != null) {
                if (c0545a.errorCode != 0) {
                    this.evO.aqL().a(c0545a, bcz.get(c0545a.evD), new com.baidu.swan.pms.model.a(c0545a.errorCode, c0545a.evD + "，Server返回错误"));
                } else {
                    if (c0545a.ewv != null) {
                        for (com.baidu.swan.pms.model.g gVar : c0545a.ewv) {
                            if (gVar != null) {
                                gVar.appId = c0545a.evD;
                            }
                        }
                        a(c0545a.ewv, fVar);
                        arrayList.addAll(c0545a.ewv);
                    }
                    if (c0545a.ewu != null && c0545a.eww != null) {
                        c0545a.eww.appId = c0545a.evD;
                        a(c0545a.ewu, fVar);
                    } else {
                        PMSAppInfo pMSAppInfo = bcz.get(c0545a.evD);
                        if (pMSAppInfo == null) {
                            if (c0545a.eww != null) {
                                c0545a.eww.appId = c0545a.evD;
                                if (c0545a.ewv != null && !c0545a.ewv.isEmpty()) {
                                    c0545a.eww.m(c0545a.ewv.get(0));
                                }
                                this.evO.aqL().b(c0545a.eww, null);
                            } else {
                                this.evO.aqL().a(c0545a, null, new com.baidu.swan.pms.model.a(c0545a.errorCode, c0545a.evD + "，本地记录不存在"));
                            }
                        } else if (c0545a.ewu == null && c0545a.eww != null) {
                            c0545a.eww.appId = c0545a.evD;
                            this.evO.aqL().b(c0545a.eww, pMSAppInfo);
                        } else if (c0545a.ewu != null && c0545a.eww == null) {
                            c0545a.ewx = true;
                            c0545a.eww = pMSAppInfo;
                            a(c0545a.ewu, fVar);
                        }
                    }
                }
            }
        }
        if (fVar.bdN() == 0) {
            this.evO.anJ();
        } else {
            this.evO.a(fVar);
            com.baidu.swan.pms.c.a.a.a(aVar, arrayList, this.evO);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ap(com.baidu.swan.pms.c.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.ewt == null || aVar.ewt.isEmpty()) {
            return false;
        }
        for (a.C0545a c0545a : aVar.ewt) {
            if (TextUtils.isEmpty(c0545a.evD)) {
                return false;
            }
            if (c0545a.errorCode == 0) {
                if (c0545a.ewu == null && c0545a.eww == null && c0545a.ewv == null) {
                    return false;
                }
                if (c0545a.ewu != null && !c0545a.ewu.arC()) {
                    return false;
                }
                if (c0545a.eww != null && !c0545a.eww.arC()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcM() {
        return "getpkglist";
    }
}
