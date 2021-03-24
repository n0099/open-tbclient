package com.baidu.sapi2.ecommerce.result;

import com.baidu.pass.ecommerce.common.MapObject;
/* loaded from: classes2.dex */
public class AddrSelectorRequestParam extends MapObject {
    public static String KEY_CLIENT = "client";
    public static String KEY_CLIENTFROM = "clientfrom";
    public static String KEY_ID = "id";
    public static String KEY_LEAFS = "leafs";
    public static String KEY_SORT = "sort";
    public static String KEY_TPL = "tpl";
    public static String KEY_TPLSE = "tplse";
    public static String KEY_TPLT = "tplt";
    public static String KEY_TTT = "ttt";

    public String getClient() {
        return getStrValue(KEY_CLIENT);
    }

    public String getClientFrom() {
        return getStrValue(KEY_CLIENTFROM);
    }

    public String getId() {
        return getStrValue(KEY_ID);
    }

    public String getLeafs() {
        return getStrValue(KEY_LEAFS);
    }

    public String getSort() {
        return getStrValue(KEY_SORT);
    }

    public String getTpl() {
        return getStrValue(KEY_TPL);
    }

    public String getTplse() {
        return getStrValue(KEY_TPLSE);
    }

    public String getTplt() {
        return getStrValue(KEY_TPLT);
    }

    public String getTtt() {
        return getStrValue(KEY_TTT);
    }

    public void setClient(String str) {
        putValue(KEY_CLIENT, str);
    }

    public void setClientFrom(String str) {
        putValue(KEY_CLIENTFROM, str);
    }

    public void setId(String str) {
        putValue(KEY_ID, str);
    }

    public void setLeafs(String str) {
        putValue(KEY_LEAFS, str);
    }

    public void setSort(String str) {
        putValue(KEY_SORT, str);
    }

    public void setTpl(String str) {
        putValue(KEY_TPL, str);
    }

    public void setTplse(String str) {
        putValue(KEY_TPLSE, str);
    }

    public void setTplt(String str) {
        putValue(KEY_TPLT, str);
    }

    public void setTtt(String str) {
        putValue(KEY_TTT, str);
    }
}
