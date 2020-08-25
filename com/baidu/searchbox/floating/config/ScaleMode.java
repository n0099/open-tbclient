package com.baidu.searchbox.floating.config;

import kotlin.Pair;
import kotlin.h;
@h
/* loaded from: classes19.dex */
public enum ScaleMode {
    S { // from class: com.baidu.searchbox.floating.config.ScaleMode.S
        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode next() {
            return ScaleMode.M;
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public ScaleMode pre() {
            return ScaleMode.M;
        }

        @Override // com.baidu.searchbox.floating.config.ScaleMode
        public Pair<Integer, Integer> scale(int i, int i2) {
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
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
}
