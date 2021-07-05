package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ATTRS;
    public static final int HORIZONTAL = 0;
    public static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect mBounds;
    public Drawable mDivider;
    public int mOrientation;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-310476519, "Landroidx/recyclerview/widget/DividerItemDecoration;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-310476519, "Landroidx/recyclerview/widget/DividerItemDecoration;");
                return;
            }
        }
        ATTRS = new int[]{16843284};
    }

    public DividerItemDecoration(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBounds = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ATTRS);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.mDivider = drawable;
        if (drawable == null) {
            Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        setOrientation(i2);
    }

    private void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, canvas, recyclerView) == null) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i2 = recyclerView.getPaddingTop();
                height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
            } else {
                height = recyclerView.getHeight();
                i2 = 0;
            }
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.mBounds);
                int round = this.mBounds.right + Math.round(childAt.getTranslationX());
                this.mDivider.setBounds(round - this.mDivider.getIntrinsicWidth(), i2, round, height);
                this.mDivider.draw(canvas);
            }
            canvas.restore();
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, canvas, recyclerView) == null) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i2 = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i2, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                i2 = 0;
            }
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                int round = this.mBounds.bottom + Math.round(childAt.getTranslationY());
                this.mDivider.setBounds(i2, round - this.mDivider.getIntrinsicHeight(), width, round);
                this.mDivider.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Nullable
    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDivider : (Drawable) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect, view, recyclerView, state) == null) {
            Drawable drawable = this.mDivider;
            if (drawable == null) {
                rect.set(0, 0, 0, 0);
            } else if (this.mOrientation == 1) {
                rect.set(0, 0, 0, drawable.getIntrinsicHeight());
            } else {
                rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, recyclerView, state) == null) || recyclerView.getLayoutManager() == null || this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setDrawable(@NonNull Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, drawable) == null) {
            if (drawable != null) {
                this.mDivider = drawable;
                return;
            }
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != 0 && i2 != 1) {
                throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
            }
            this.mOrientation = i2;
        }
    }
}
