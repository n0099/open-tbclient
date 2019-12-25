package com.baidu.live.tbadk.widget.flex;

import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class FlexAdapter<T> {
    private Callback mCallback;
    private List<T> mDatas;

    /* loaded from: classes2.dex */
    interface Callback {
        void onChanged();
    }

    public abstract View getView(int i, ViewGroup viewGroup);

    public FlexAdapter() {
    }

    public FlexAdapter(List<T> list) {
        this.mDatas = list;
    }

    public FlexAdapter(T[] tArr) {
        this.mDatas = Arrays.asList(tArr);
    }

    public void setDatas(List<T> list) {
        this.mDatas = list;
    }

    public void setDatas(T[] tArr) {
        this.mDatas = Arrays.asList(tArr);
    }

    public int getCount() {
        if (this.mDatas == null) {
            return 0;
        }
        return this.mDatas.size();
    }

    public T getItem(int i) {
        if (getCount() > i) {
            return this.mDatas.get(i);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        if (this.mCallback != null) {
            this.mCallback.onChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }
}
