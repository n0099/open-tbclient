package com.baidu.tbadk.core.util.resourceLoader;

import com.baidu.adp.lib.e.f;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public abstract class a implements f {
    protected abstract Object a(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar);

    protected abstract Object a(String str, com.baidu.tbadk.core.util.b bVar);

    protected abstract Object b(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, com.baidu.tbadk.core.util.e eVar);

    @Override // com.baidu.adp.lib.e.f
    public Object a(String str, com.baidu.adp.lib.e.e eVar) {
        if (eVar == null) {
            return null;
        }
        com.baidu.tbadk.core.util.b bVar = (com.baidu.tbadk.core.util.b) eVar.a("AsyncImageLoader");
        com.baidu.tbadk.core.util.e eVar2 = (com.baidu.tbadk.core.util.e) eVar.a("ImageAsyncTaskInfo");
        if (bVar == null || eVar2 == null) {
            return null;
        }
        if (eVar2.n) {
            return null;
        }
        return a(str, bVar);
    }

    @Override // com.baidu.adp.lib.e.f
    public Object a(String str, com.baidu.adp.lib.e.d dVar) {
        com.baidu.adp.lib.e.e a = dVar.a();
        if (a == null) {
            return null;
        }
        com.baidu.tbadk.core.util.b bVar = (com.baidu.tbadk.core.util.b) a.a("AsyncImageLoader");
        com.baidu.tbadk.core.util.e eVar = (com.baidu.tbadk.core.util.e) a.a("ImageAsyncTaskInfo");
        if (bVar == null || eVar == null) {
            return null;
        }
        if (eVar.g && !eVar.n) {
            long currentTimeMillis = System.currentTimeMillis();
            Object a2 = a(str, dVar, bVar, eVar);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 >= 300) {
                TiebaStatic.imgError("", TbErrInfo.PIC_IMG_TIME, "load local pic : " + currentTimeMillis2, str);
                return a2;
            }
            return a2;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.f
    public Object b(String str, com.baidu.adp.lib.e.d dVar) {
        com.baidu.adp.lib.e.e a = dVar.a();
        if (a == null) {
            return null;
        }
        com.baidu.tbadk.core.util.b bVar = (com.baidu.tbadk.core.util.b) a.a("AsyncImageLoader");
        com.baidu.tbadk.core.util.e eVar = (com.baidu.tbadk.core.util.e) a.a("ImageAsyncTaskInfo");
        if (bVar == null || eVar == null) {
            return null;
        }
        if (eVar.n) {
            return null;
        }
        return b(str, dVar, bVar, eVar);
    }
}
