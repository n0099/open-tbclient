package com.baidu.swan.apps.view.loading;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.Resources;
import com.baidu.tieba.R;
import com.baidu.tieba.ku2;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R%\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/baidu/swan/apps/view/loading/SwanLoadingTips;", "", "getNextLoadingTips", "()Ljava/lang/String;", "", "currentTipsPosition", "I", "", "loadingTips$delegate", "Lkotlin/Lazy;", "getLoadingTips", "()[Ljava/lang/String;", "loadingTips", "<init>", "()V", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes4.dex */
public final class SwanLoadingTips {
    public final Lazy a = LazyKt__LazyJVMKt.lazy(new Function0<String[]>() { // from class: com.baidu.swan.apps.view.loading.SwanLoadingTips$loadingTips$2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        public final String[] invoke() {
            Resources resources;
            Resources resources2;
            if (((int) (Math.random() * 2)) != 0) {
                Application c = ku2.c();
                if (c == null || (resources2 = c.getResources()) == null) {
                    return null;
                }
                return resources2.getStringArray(R.array.obfuscated_res_0x7f03000e);
            }
            Application c2 = ku2.c();
            if (c2 == null || (resources = c2.getResources()) == null) {
                return null;
            }
            return resources.getStringArray(R.array.obfuscated_res_0x7f03000f);
        }
    });
    public int b;

    public final String[] a() {
        return (String[]) this.a.getValue();
    }

    public final String b() {
        boolean z;
        String[] a = a();
        if (a != null) {
            if (a.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                int i = this.b;
                String str = a[i % a.length];
                this.b = i + 1;
                return str;
            }
            return "";
        }
        return "";
    }
}
