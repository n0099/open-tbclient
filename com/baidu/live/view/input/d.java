package com.baidu.live.view.input;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public interface d {

    /* loaded from: classes4.dex */
    public interface a {
        boolean LE();

        boolean Ld();

        int Li();

        void Wj();

        void Wk();
    }

    void GK();

    List<String> Ok();

    void a(a aVar);

    void b(w wVar, String str);

    void b(boolean z, int i, int i2, String str);

    void d(TbPageContext tbPageContext);

    void hh(String str);

    void release();
}
