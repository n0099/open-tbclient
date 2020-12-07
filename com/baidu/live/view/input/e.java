package com.baidu.live.view.input;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public interface e {

    /* loaded from: classes4.dex */
    public interface a {
        boolean NR();

        boolean Nh();

        int Nm();

        void YJ();

        void YK();
    }

    void IB();

    List<String> QD();

    void a(a aVar);

    void b(w wVar, String str);

    void b(boolean z, int i, int i2, String str);

    void d(TbPageContext tbPageContext);

    void hC(String str);

    void release();
}
