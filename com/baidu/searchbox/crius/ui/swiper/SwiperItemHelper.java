package com.baidu.searchbox.crius.ui.swiper;

import android.util.Log;
import com.baidu.searchbox.crius.CriusRuntime;
import com.baidu.searchbox.crius.parser.CriusData;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class SwiperItemHelper {
    public static final String TAG = "SwiperItemHelper";
    public List<CriusData> mBannerItems = new LinkedList();

    private void clear() {
        List<CriusData> list = this.mBannerItems;
        if (list != null) {
            list.clear();
        }
    }

    public int getItemCount() {
        return this.mBannerItems.size();
    }

    public void appendChildAt(CriusData criusData, int i) {
        if (i == 0 && getItemCount() > 0) {
            clear();
        }
        this.mBannerItems.add(i, criusData);
        if (CriusRuntime.DEBUG) {
            Log.d(TAG, "#appendChildAt#, index: " + i + ", size: " + this.mBannerItems.size());
        }
    }

    public CriusData getNode(int i) {
        if (i < this.mBannerItems.size() && i >= 0) {
            return this.mBannerItems.get(i);
        }
        return null;
    }
}
