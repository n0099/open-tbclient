package com.baidu.searchbox.floating.config;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0002\u001a\u00020\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0000H&¢\u0006\u0004\b\u0004\u0010\u0003J+\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/floating/config/ScaleMode;", "Ljava/lang/Enum;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Lcom/baidu/searchbox/floating/config/ScaleMode;", "pre", "", "x", "y", "Lkotlin/Pair;", "scale", "(II)Lkotlin/Pair;", "<init>", "(Ljava/lang/String;I)V", ExifInterface.LATITUDE_SOUTH, "M", "L", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public enum ScaleMode {
    S { // from class: com.baidu.searchbox.floating.config.ScaleMode.S
        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public Pair<Integer, Integer> scale(int i, int i2) {
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode next() {
            return ScaleMode.M;
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode pre() {
            return ScaleMode.M;
        }
    },
    M { // from class: com.baidu.searchbox.floating.config.ScaleMode.M
        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public Pair<Integer, Integer> scale(int i, int i2) {
            return new Pair<>(Integer.valueOf((int) (i * 1.25d)), Integer.valueOf((int) (i2 * 1.25d)));
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode next() {
            return ScaleMode.L;
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode pre() {
            return ScaleMode.S;
        }
    },
    L { // from class: com.baidu.searchbox.floating.config.ScaleMode.L
        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public Pair<Integer, Integer> scale(int i, int i2) {
            return new Pair<>(Integer.valueOf((int) (i * 1.5d)), Integer.valueOf((int) (i2 * 1.5d)));
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode next() {
            return ScaleMode.M;
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode pre() {
            return ScaleMode.M;
        }
    };

    public abstract ScaleMode next();

    public abstract ScaleMode pre();

    public abstract Pair<Integer, Integer> scale(int i, int i2);

    /* synthetic */ ScaleMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
