package com.baidu.android.bbalbs.common.util;

import com.baidu.android.bbalbs.common.util.b;
import java.util.Comparator;
/* loaded from: classes.dex */
public class c implements Comparator<b.a> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f2544a;

    public c(b bVar) {
        this.f2544a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b.a aVar, b.a aVar2) {
        int i2 = aVar2.f2538b - aVar.f2538b;
        if (i2 == 0) {
            if (aVar.f2540d && aVar2.f2540d) {
                return 0;
            }
            if (aVar.f2540d) {
                return -1;
            }
            if (aVar2.f2540d) {
                return 1;
            }
        }
        return i2;
    }
}
