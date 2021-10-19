package com.baidu.swan.games.view.recommend.listmode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.f.b;
import c.a.p0.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ListRecommendDivider extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f47112a;

    /* renamed from: b  reason: collision with root package name */
    public int f47113b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f47114c;

    public ListRecommendDivider(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Resources resources = context.getResources();
        this.f47112a = resources.getDimensionPixelSize(c.swangame_recommend_dialog_list_divider_height);
        this.f47113b = resources.getDimensionPixelSize(c.swangame_recommend_dialog_list_divider_margin);
        Paint paint = new Paint();
        this.f47114c = paint;
        paint.setColor(resources.getColor(b.swangame_recommend_dialog_list_divider));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            rect.set(0, 0, 0, this.f47112a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, recyclerView, state) == null) {
            int itemCount = recyclerView.getAdapter().getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != null && recyclerView.getChildAdapterPosition(childAt) != itemCount - 1) {
                    canvas.drawRect(this.f47113b, childAt.getBottom(), childAt.getWidth() - this.f47113b, childAt.getBottom() + this.f47112a, this.f47114c);
                }
            }
        }
    }
}
