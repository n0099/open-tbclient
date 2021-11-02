package com.baidu.android.lbspay.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ChannelDescLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TextView> descListViews;
    public int mwidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelDescLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.descListViews = null;
        this.mwidth = 0;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.baidu.android.lbspay.view.ChannelDescLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ChannelDescLayout f34900a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34900a = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int childCount = this.f34900a.getChildCount();
                    int paddingLeft = this.f34900a.getPaddingLeft();
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = this.f34900a.getChildAt(i5);
                        if (childAt instanceof TextView) {
                            TextView textView = (TextView) childAt;
                            i4 = ((int) (textView.getPaint().measureText(textView.getText().toString()) + 0.5d)) + childAt.getPaddingLeft() + childAt.getPaddingRight();
                        } else {
                            i4 = 10;
                        }
                        paddingLeft += i4;
                        if (this.f34900a.mwidth < paddingLeft) {
                            return;
                        }
                        childAt.setVisibility(0);
                    }
                }
            }
        });
    }

    private String[] getChannelDesc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.split("\\|");
        }
        return (String[]) invokeL.objValue;
    }

    private View makeGapView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            View view = new View(getContext());
            layoutParams.width = 10;
            layoutParams.height = 1;
            view.setLayoutParams(layoutParams);
            return view;
        }
        return (View) invokeV.objValue;
    }

    private TextView makeTextView(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, ResUtils.getDimension(getContext(), "lbspay_textsize_10"));
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            textView.setSingleLine(true);
            textView.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_juhe_channel_desc_bg"));
            textView.setPadding(8, 4, 8, 4);
            int color = ResUtils.getColor(getContext(), "lbspay_color_e85352");
            textView.setTextColor(Color.argb(178, Color.red(color), Color.green(color), Color.blue(color)));
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public void addDescView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.descListViews != null) {
                this.descListViews = null;
            }
            this.descListViews = new ArrayList();
            String[] channelDesc = getChannelDesc(str);
            if (channelDesc == null || channelDesc.length <= 0) {
                return;
            }
            for (int i2 = 0; i2 < channelDesc.length; i2++) {
                if (!TextUtils.isEmpty(channelDesc[i2].trim())) {
                    TextView makeTextView = makeTextView(channelDesc[i2]);
                    makeTextView.setVisibility(8);
                    addView(makeTextView);
                    this.descListViews.add(makeTextView);
                    View makeGapView = makeGapView();
                    makeGapView.setVisibility(8);
                    addView(makeGapView);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.mwidth = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
        }
    }

    public void setTextColor(int i2) {
        List<TextView> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (list = this.descListViews) == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.descListViews.size(); i3++) {
            this.descListViews.get(i3).setTextColor(i2);
        }
    }
}
