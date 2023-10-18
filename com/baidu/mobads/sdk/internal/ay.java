package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.support.v4.media.RatingCompat;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ay() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            try {
                ViewCompat.generateViewId();
                AccessibilityNodeInfoCompat.obtain();
                LocalBroadcastManager.getInstance(context);
                new ViewPager(context);
                new NestedScrollView(context);
                new Fragment();
                new SwipeRefreshLayout(context);
                new RecyclerView(context);
                RatingCompat.newPercentageRating(1.0f);
                new ArraySet();
                new LongSparseArray();
                new LinearLayoutManager(context);
                new PagerSnapHelper();
            } catch (Throwable th) {
                br.a().a(th);
            }
        }
    }
}
