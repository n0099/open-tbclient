package com.baidu.android.bbalbs.common.util;

import com.baidu.android.bbalbs.common.util.b;
import java.util.Comparator;
/* loaded from: classes.dex */
public class c implements Comparator<b.a> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f2547a;

    public c(b bVar) {
        this.f2547a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b.a aVar, b.a aVar2) {
        int i = aVar2.f2541b - aVar.f2541b;
        if (i == 0) {
            if (aVar.f2543d && aVar2.f2543d) {
                return 0;
            }
            if (aVar.f2543d) {
                return -1;
            }
            if (aVar2.f2543d) {
                return 1;
            }
        }
        return i;
    }
}
