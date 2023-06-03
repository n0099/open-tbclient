package com.baidu.searchbox.floating.config;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0000H&J\b\u0010\u0004\u001a\u00020\u0000H&J$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/floating/config/ScaleMode;", "", "(Ljava/lang/String;I)V", "next", "pre", "scale", "Lkotlin/Pair;", "", "x", "y", ExifInterface.LATITUDE_SOUTH, "M", "L", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* synthetic */ ScaleMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract ScaleMode next();

    public abstract ScaleMode pre();

    public abstract Pair<Integer, Integer> scale(int i, int i2);
}
