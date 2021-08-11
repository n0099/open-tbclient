package c.a.p0.m1.c;

import c.a.p0.m1.b.b;
import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import java.util.List;
/* loaded from: classes3.dex */
public interface a {
    void callback(LabelRequestEnum labelRequestEnum, b bVar, int i2);

    void getLabel();

    void subLabel(List<Integer> list);
}
