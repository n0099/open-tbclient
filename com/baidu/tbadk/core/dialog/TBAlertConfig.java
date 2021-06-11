package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public final class TBAlertConfig {

    /* loaded from: classes3.dex */
    public enum OperateBtnStyle {
        MAIN,
        FORCE,
        SECONDARY,
        ALERT
    }

    /* loaded from: classes3.dex */
    public enum OperateType {
        ONE,
        TWO,
        THREE
    }

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f12133a;

        /* renamed from: b  reason: collision with root package name */
        public OperateBtnStyle f12134b;

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f12135c;

        public a(@StringRes int i2, @NonNull OperateBtnStyle operateBtnStyle) {
            this(i2, operateBtnStyle, null);
        }

        public void a(View.OnClickListener onClickListener) {
            this.f12135c = onClickListener;
        }

        public a(@StringRes int i2, @NonNull OperateBtnStyle operateBtnStyle, View.OnClickListener onClickListener) {
            this.f12133a = TbadkCoreApplication.getInst().getResources().getString(i2);
            this.f12134b = operateBtnStyle;
            this.f12135c = onClickListener;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final OperateType f12136a;

        /* renamed from: b  reason: collision with root package name */
        public a f12137b;

        /* renamed from: c  reason: collision with root package name */
        public a f12138c;

        /* renamed from: d  reason: collision with root package name */
        public a f12139d;

        public b(OperateType operateType) {
            this.f12136a = operateType;
        }

        public static b a(a aVar) {
            b bVar = new b(OperateType.ONE);
            bVar.f12137b = aVar;
            return bVar;
        }

        public static b b(a aVar, a aVar2, a aVar3) {
            b bVar = new b(OperateType.THREE);
            bVar.f12137b = aVar;
            bVar.f12138c = aVar2;
            bVar.f12139d = aVar3;
            return bVar;
        }

        public static b c(a aVar, a aVar2) {
            b bVar = new b(OperateType.TWO);
            bVar.f12137b = aVar;
            bVar.f12138c = aVar2;
            return bVar;
        }
    }

    public static b a(a aVar) {
        return b.a(aVar);
    }

    public static b b(a aVar, a aVar2, a aVar3) {
        return b.b(aVar, aVar2, aVar3);
    }

    public static b c(a aVar, a aVar2) {
        return b.c(aVar, aVar2);
    }
}
