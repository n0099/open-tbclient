package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.zr0;
import java.util.Map;
/* loaded from: classes3.dex */
public class RequestParameters {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    @Nullable
    public final zr0 e;
    @NonNull
    public final RefreshType f;
    public final String g;
    public final String h;
    public final String i;
    public final SlotType j;
    @Nullable
    public final Map<String, String> k;
    @Nullable
    public final Map<String, String> l;
    public final boolean m;

    /* loaded from: classes3.dex */
    public enum SlotType {
        DEFAULT,
        SPLASH,
        FEED,
        BANNER,
        DRAW,
        REWARD
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String a;
        public String c;
        public String d;
        public zr0 e;
        public String g;
        public String i;
        public String j;
        public Map<String, String> k;
        public Map<String, String> l;
        public int b = 1;
        public RefreshType f = RefreshType.NONE;
        public SlotType h = SlotType.DEFAULT;
        public boolean m = false;

        public RequestParameters o() {
            return new RequestParameters(this);
        }

        public b n(@NonNull Map<String, String> map) {
            this.l = map;
            return this;
        }

        public b p(int i) {
            this.b = (i <= 0 || i >= 10) ? 2 : 2;
            return this;
        }

        public b q(String str) {
            this.a = str;
            return this;
        }
    }

    public RequestParameters(@NonNull b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.d;
        this.d = bVar.c;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.i;
        this.i = bVar.j;
        this.j = bVar.h;
        this.k = bVar.k;
        this.m = bVar.m;
        this.l = bVar.l;
    }

    /* loaded from: classes3.dex */
    public enum RefreshType {
        NONE(null),
        PULL_UP("3"),
        PULL_DOWN("4");
        
        public final String value;

        RefreshType(String str) {
            this.value = str;
        }
    }
}
