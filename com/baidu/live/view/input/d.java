package com.baidu.live.view.input;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes11.dex */
public interface d {

    /* loaded from: classes11.dex */
    public interface a {
        boolean KW();

        boolean Kh();

        int Kn();

        boolean Ko();

        void XS();

        void XT();
    }

    void Fy();

    List<String> Pl();

    void a(a aVar);

    void b(ab abVar, String str);

    void b(boolean z, int i, int i2, String str);

    void cr(int i);

    void d(TbPageContext tbPageContext);

    void gz(String str);

    void release();
}
