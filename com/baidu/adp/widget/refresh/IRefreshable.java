package com.baidu.adp.widget.refresh;
/* loaded from: classes.dex */
public interface IRefreshable {

    /* loaded from: classes.dex */
    public enum State {
        idle,
        pulling_no_refresh,
        animating,
        pulling_refresh
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(State state);

        void pd();

        void pe();

        void pf();
    }
}
