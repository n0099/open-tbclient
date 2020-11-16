package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class UgcQuanInfo implements NoProGuard, Serializable {
    @c("id")
    public String quanId;
    @c("name")
    public String quanName;
    @c("quanzhu_uk")
    public String quanZhuUk;
    @c("type")
    public String type;
    @c("type_info")
    public List<QuanziTypeInfo> typeInfoList = new ArrayList();

    /* loaded from: classes9.dex */
    public class QuanziTypeInfo implements NoProGuard, Serializable {
        @c("text")
        public String text;
        @c("type")
        public String type;

        public QuanziTypeInfo() {
        }
    }
}
