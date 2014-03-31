package com.baidu.tbadk.core.util.resourceLoader;

import com.baidu.adp.lib.e.f;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.e;
/* loaded from: classes.dex */
public abstract class a implements f {
    public static final String KEY_AsyncImageLoader = "AsyncImageLoader";
    public static final String KEY_ImageAsyncTask = "ImageAsyncTaskInfo";

    protected abstract Object doGetFromLocal(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, e eVar);

    protected abstract Object doGetFromMemory(String str, com.baidu.tbadk.core.util.b bVar);

    protected abstract Object doGetFromRemote(String str, com.baidu.adp.lib.e.d dVar, com.baidu.tbadk.core.util.b bVar, e eVar);

    @Override // com.baidu.adp.lib.e.f
    public Object getFromMemory(String str, com.baidu.adp.lib.e.e eVar) {
        if (eVar == null) {
            return null;
        }
        com.baidu.tbadk.core.util.b bVar = (com.baidu.tbadk.core.util.b) eVar.a(KEY_AsyncImageLoader);
        e eVar2 = (e) eVar.a(KEY_ImageAsyncTask);
        if (bVar == null || eVar2 == null) {
            return null;
        }
        if (eVar2.n) {
            return null;
        }
        return doGetFromMemory(str, bVar);
    }

    @Override // com.baidu.adp.lib.e.f
    public Object getFromLocal(String str, com.baidu.adp.lib.e.d dVar) {
        com.baidu.adp.lib.e.e a = dVar.a();
        if (a == null) {
            return null;
        }
        com.baidu.tbadk.core.util.b bVar = (com.baidu.tbadk.core.util.b) a.a(KEY_AsyncImageLoader);
        e eVar = (e) a.a(KEY_ImageAsyncTask);
        if (bVar == null || eVar == null) {
            return null;
        }
        if (eVar.g && !eVar.n) {
            long currentTimeMillis = System.currentTimeMillis();
            Object doGetFromLocal = doGetFromLocal(str, dVar, bVar, eVar);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 >= 300) {
                TiebaStatic.a("", -1114, "load local pic : " + currentTimeMillis2, str);
                return doGetFromLocal;
            }
            return doGetFromLocal;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.f
    public Object getFromRemote(String str, com.baidu.adp.lib.e.d dVar) {
        com.baidu.adp.lib.e.e a = dVar.a();
        if (a == null) {
            return null;
        }
        com.baidu.tbadk.core.util.b bVar = (com.baidu.tbadk.core.util.b) a.a(KEY_AsyncImageLoader);
        e eVar = (e) a.a(KEY_ImageAsyncTask);
        if (bVar == null || eVar == null) {
            return null;
        }
        if (eVar.n) {
            return null;
        }
        return doGetFromRemote(str, dVar, bVar, eVar);
    }
}
