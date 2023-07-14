package com.baidu.nadcore.player.model;

import com.baidu.tieba.f11;
import com.baidu.tieba.v21;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/baidu/nadcore/player/model/HistoryCache;", "Ljava/util/ArrayList;", "Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;", "element", "", "add", "(Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;)Z", "", "id", "vid", "findCache", "(Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;", "info", "isSameHistory", "(Lcom/baidu/nadcore/player/model/VideoPlayHistoryItemInfo;Ljava/lang/String;Ljava/lang/String;)Z", "removeCache", "<init>", "()V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class HistoryCache extends ArrayList<f11> {
    public HistoryCache() {
        super(20);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.b(), r5) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSameHistory(f11 f11Var, String str, String str2) {
        boolean z;
        boolean z2;
        String b = f11Var.b();
        if (b != null) {
            if (b.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
            }
        }
        String e = f11Var.e();
        if (e == null) {
            return false;
        }
        if (e.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !Intrinsics.areEqual(f11Var.e(), str2)) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(f11 element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (size() >= 50) {
            v21.a("remove item " + remove(0));
        }
        removeCache(element.b(), element.e());
        return super.add((HistoryCache) element);
    }

    public /* bridge */ boolean contains(f11 f11Var) {
        return super.contains((Object) f11Var);
    }

    public /* bridge */ int indexOf(f11 f11Var) {
        return super.indexOf((Object) f11Var);
    }

    public /* bridge */ int lastIndexOf(f11 f11Var) {
        return super.lastIndexOf((Object) f11Var);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ f11 remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ f11 removeAt(int i) {
        return (f11) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof f11) {
            return contains((f11) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof f11) {
            return indexOf((f11) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof f11) {
            return lastIndexOf((f11) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(f11 f11Var) {
        return super.remove((Object) f11Var);
    }

    public final f11 findCache(String str, String str2) {
        for (f11 f11Var : this) {
            if (isSameHistory(f11Var, str, str2)) {
                return f11Var;
            }
        }
        return null;
    }

    public final f11 removeCache(String str, String str2) {
        Iterator<f11> it = iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            f11 next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            f11 f11Var = next;
            if (isSameHistory(f11Var, str, str2)) {
                it.remove();
                return f11Var;
            }
        }
        return null;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof f11) {
            return remove((f11) obj);
        }
        return false;
    }
}
