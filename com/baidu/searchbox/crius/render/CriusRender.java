package com.baidu.searchbox.crius.render;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.crius.CriusDisplay;
import com.baidu.crius.CriusNode;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.crius.data.RenderData;
import com.baidu.searchbox.crius.factory.ComponentFactory;
import com.baidu.searchbox.crius.factory.NativeRenderFactory;
import com.baidu.searchbox.crius.parser.CriusData;
import com.baidu.searchbox.crius.parser.SyncInfo;
import com.baidu.searchbox.crius.render.util.RenderUtils;
import com.baidu.searchbox.crius.ui.CriusUIComponent;
import com.baidu.searchbox.crius.ui.recycler.CriusRecyclerView;
import com.baidu.searchbox.crius.ui.view.CriusLayout;
import com.baidu.searchbox.crius.util.ColorUtils;
import com.baidu.searchbox.crius.util.LinkUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import view.CriusTextView;
/* loaded from: classes2.dex */
public class CriusRender {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CriusRender";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canReuse;
    public Map<String, View> componentToView;
    public CriusData criusData;
    public IHrefClick iHrefClick;
    public Map<String, View> idToView;
    public IHScrollListener mHScrollListener;
    public boolean mIgnoreImageNightMode;
    public int mImageTemplateFlag;
    public Map<SyncInfo, List<View>> mSyncInfoToViews;
    public ViewGroup rootView;

    /* loaded from: classes2.dex */
    public interface IHScrollListener {
        void onScrollStateChanged(int i, CriusData criusData);
    }

    /* loaded from: classes2.dex */
    public interface IHrefClick {
        void onClick(View view2, String str, Map<String, String> map);
    }

    public CriusRender() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.componentToView = new HashMap();
        this.idToView = new HashMap();
        this.mSyncInfoToViews = new HashMap();
        this.mImageTemplateFlag = 1;
        this.canReuse = false;
    }

    public View getViewByComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.componentToView.get(str);
        }
        return (View) invokeL.objValue;
    }

    public View getViewById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return this.idToView.get(str);
        }
        return (View) invokeL.objValue;
    }

    @Nullable
    public List<View> getViewsBySyncInfo(@NonNull SyncInfo syncInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, syncInfo)) == null) {
            return this.mSyncInfoToViews.get(syncInfo);
        }
        return (List) invokeL.objValue;
    }

    public void setHScrollListener(IHScrollListener iHScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iHScrollListener) == null) {
            this.mHScrollListener = iHScrollListener;
        }
    }

    public void setHrefClick(IHrefClick iHrefClick) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iHrefClick) == null) {
            this.iHrefClick = iHrefClick;
        }
    }

    public void setIgnoreImageNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIgnoreImageNightMode = z;
        }
    }

    public void setImageTemplateFlag(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.mImageTemplateFlag = i;
        }
    }

    private void putSyncToView(@NonNull SyncInfo syncInfo, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, syncInfo, view2) == null) {
            List<View> list = this.mSyncInfoToViews.get(syncInfo);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(view2);
            this.mSyncInfoToViews.put(syncInfo, list);
        }
    }

    private boolean canReuse(CriusData criusData, CriusData criusData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, criusData, criusData2)) == null) {
            if (criusData == null || criusData2 == null) {
                return false;
            }
            if (!TextUtils.isEmpty(criusData.component) && !criusData.component.equals(criusData2.component)) {
                return false;
            }
            if ((!TextUtils.isEmpty(criusData.type) && (!criusData.type.equals(criusData2.type) || NativeConstants.TYPE_SWIPER.equals(criusData.type))) || !TextUtils.equals(criusData.getDisplay(), criusData2.getDisplay())) {
                return false;
            }
            if (criusData.type.equals(criusData2.type) && criusData.isText() && isTextNeedRemeasure(criusData, criusData2)) {
                return false;
            }
            List<CriusData> list = criusData.children;
            if (list != null) {
                if (criusData2.children == null || list.size() != criusData2.children.size()) {
                    return false;
                }
                int size = criusData.children.size();
                for (int i = 0; i < size; i++) {
                    if (!canReuse(criusData.children.get(i), criusData2.children.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean checkDataInCriusLayout(CriusLayout criusLayout, CriusData criusData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, criusLayout, criusData)) == null) {
            if (criusLayout == null || criusData == null || criusLayout.getCriusData() != criusData) {
                return false;
            }
            if (criusLayout.getChildCount() > 0) {
                if (criusData.children == null || criusLayout.getChildCount() != criusData.children.size()) {
                    return false;
                }
                int childCount = criusLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = criusLayout.getChildAt(i);
                    if ((childAt instanceof CriusLayout) && !checkDataInCriusLayout((CriusLayout) childAt, criusData.children.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    private boolean isTextNeedRemeasure(CriusData criusData, CriusData criusData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, criusData, criusData2)) == null) {
            if (TextUtils.equals(criusData.text, criusData2.text) && criusData.lineSpace == criusData2.lineSpace && criusData.lineMulti == criusData2.lineMulti && criusData.maxLines == criusData2.maxLines && criusData.ignoreTextPadding == criusData2.ignoreTextPadding && criusData.fontSize() == criusData2.fontSize()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> generateHrefExtraInfo(CriusData criusData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, criusData)) == null) {
            if (criusData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(NativeConstants.ALS_STAT, criusData.alsStat);
            hashMap.put(NativeConstants.STAT, criusData.stat);
            hashMap.put(NativeConstants.URL_STAT, criusData.urlStat);
            hashMap.put(NativeConstants.CHARGE_TYPE, criusData.chargeType);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    private void recursiveRender(Context context, CriusData criusData, View view2, boolean z, boolean z2) {
        CriusNode criusNode;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{context, criusData, view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && criusData != null && (criusNode = criusData.criusNode) != null && view2 != null) {
            if (criusNode.getDisplay() == CriusDisplay.NONE) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(0);
            }
            if (!TextUtils.isEmpty(criusData.component)) {
                renderComponent(criusData.component, view2, criusData, z, z2);
                if (NativeConstants.COMPONENT_VIEWBTN.equals(criusData.component)) {
                    renderNative(context, view2, criusData, z, z2);
                }
            } else {
                renderNative(context, view2, criusData, z, z2);
            }
            setLink(context, view2, criusData);
            setRVScrollListener(context, view2, criusData);
            List<CriusData> list = criusData.children;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < criusData.children.size(); i++) {
                    View view3 = null;
                    CriusData criusData2 = criusData.children.get(i);
                    if (this.canReuse && (view2 instanceof ViewGroup)) {
                        view3 = criusData.getUI().getChildAt(i);
                    }
                    if (view3 == null && !this.canReuse && (view3 = criusData2.createView(context)) != null) {
                        if (criusData2.getUI() instanceof CriusUIComponent) {
                            this.componentToView.put(criusData2.component, view3);
                        }
                        if (!TextUtils.isEmpty(criusData2.id)) {
                            this.idToView.put(criusData2.id, view3);
                        }
                        SyncInfo syncInfo = criusData2.syncInfo;
                        if (syncInfo != null && syncInfo.isDataValid()) {
                            putSyncToView(criusData2.syncInfo, view3);
                        }
                    }
                    recursiveRenderChildren(context, criusData2, view3, z, z2);
                    if (!this.canReuse) {
                        criusData.insertChild(criusData2, i);
                    }
                }
            }
        }
    }

    private void recursiveRenderChildren(Context context, CriusData criusData, View view2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{context, criusData, view2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            recursiveRender(context, criusData, view2, z, z2);
        }
    }

    private void renderComponent(String str, View view2, CriusData criusData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, this, new Object[]{str, view2, criusData, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || criusData == null) {
            return;
        }
        view2.setMinimumWidth((int) criusData.criusNode.getLayoutWidth());
        view2.setMinimumHeight((int) criusData.criusNode.getLayoutHeight());
        ComponentFactory.getInstance().renderComponent(str, view2, RenderData.initFrom(criusData, z, z2), z, this.mIgnoreImageNightMode, z2);
    }

    private void renderNative(Context context, View view2, CriusData criusData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{context, view2, criusData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && context != null && criusData != null) {
            RenderData initFrom = RenderData.initFrom(criusData, z, z2);
            RenderUtils.setBackground(view2, criusData.type, initFrom, z, z2);
            RenderUtils.setInitAlphaAndController(view2, RenderData.Opacities.initFrom(criusData), z, z2);
            renderVideoView(view2, criusData, z, z2);
            renderImageView(view2, criusData, z, z2);
            RenderUtils.renderTextView(view2, initFrom, z, z2);
        }
    }

    private void renderImageView(View view2, CriusData criusData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{view2, criusData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && view2 != null && criusData != null) {
            if ("image".equalsIgnoreCase(criusData.type) || NativeConstants.TYPE_GIF.equals(criusData.type)) {
                view2.setMinimumWidth((int) criusData.criusNode.getLayoutWidth());
                view2.setMinimumHeight((int) criusData.criusNode.getLayoutHeight());
                RenderData renderData = new RenderData();
                renderData.src = criusData.imageSrc(z, z2);
                renderData.width = (int) criusData.criusNode.getLayoutWidth();
                renderData.height = (int) criusData.criusNode.getLayoutHeight();
                renderData.borderRadius = criusData.convertedBorderRadius();
                renderData.borderRadiusWidth = criusData.convertedBorderWidth();
                renderData.borderRadiusColor = ColorUtils.parseColor(criusData.borderColor);
                renderData.borderRadiusLeftTop = criusData.convertedBorderRadiusLT();
                renderData.borderRadiusLeftBottom = criusData.convertedBorderRadiusLB();
                renderData.borderRadiusRightTop = criusData.convertedBorderRadiusRT();
                renderData.borderRadiusRightBottom = criusData.convertedBorderRadiusRB();
                renderData.placeHolderImage = criusData.placeHolderImage;
                renderData.placeHolderImageNight = criusData.placeHolderImageNight;
                renderData.backgroundImage = criusData.backgroundImage;
                renderData.backgroundImageNight = criusData.backgroundImageNight;
                renderData.imageTemplateFlag = this.mImageTemplateFlag;
                renderData.imageScaleType = criusData.imageScaleType;
                renderData.placeHolderScaleType = criusData.placeHolderScaleType;
                renderData.focusPoint = criusData.focusPoint;
                NativeRenderFactory.getInstance().renderView(criusData.type, view2, renderData, z, this.mIgnoreImageNightMode);
            }
        }
    }

    private void renderVideoView(View view2, CriusData criusData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{view2, criusData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && criusData != null && "video".equalsIgnoreCase(criusData.type)) {
            view2.setMinimumWidth((int) criusData.criusNode.getLayoutWidth());
            view2.setMinimumHeight((int) criusData.criusNode.getLayoutHeight());
            RenderData renderData = new RenderData();
            renderData.src = criusData.imageSrc(z, z2);
            renderData.poster = criusData.poster;
            renderData.videoDuration = criusData.videoDuration;
            renderData.width = (int) criusData.criusNode.getLayoutWidth();
            renderData.height = (int) criusData.criusNode.getLayoutHeight();
            NativeRenderFactory.getInstance().renderView("video", view2, renderData, z, this.mIgnoreImageNightMode);
        }
    }

    private void setLink(Context context, View view2, CriusData criusData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65551, this, context, view2, criusData) == null) && view2 != null && criusData != null) {
            String decoratedHref = criusData.decoratedHref();
            if (TextUtils.isEmpty(decoratedHref)) {
                return;
            }
            view2.setClickable(true);
            view2.setOnClickListener(new View.OnClickListener(this, decoratedHref, criusData, context) { // from class: com.baidu.searchbox.crius.render.CriusRender.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CriusRender this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ CriusData val$criusData;
                public final /* synthetic */ String val$href;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, decoratedHref, criusData, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$href = decoratedHref;
                    this.val$criusData = criusData;
                    this.val$context = context;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, view3) != null) || TextUtils.isEmpty(this.val$href)) {
                        return;
                    }
                    if (this.this$0.iHrefClick != null) {
                        this.this$0.iHrefClick.onClick(view3, this.val$href, this.this$0.generateHrefExtraInfo(this.val$criusData));
                    } else {
                        LinkUtil.dealLink(this.val$context, this.val$href);
                    }
                }
            });
        }
    }

    private void setRVScrollListener(Context context, View view2, CriusData criusData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65552, this, context, view2, criusData) == null) && (view2 instanceof CriusRecyclerView) && criusData.isHScroll()) {
            ((CriusRecyclerView) view2).addOnScrollListener(new RecyclerView.OnScrollListener(this, criusData) { // from class: com.baidu.searchbox.crius.render.CriusRender.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CriusRender this$0;
                public final /* synthetic */ CriusData val$criusData;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, criusData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$criusData = criusData;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i) == null) && this.this$0.mHScrollListener != null) {
                        this.this$0.mHScrollListener.onScrollStateChanged(i, this.val$criusData);
                    }
                }
            });
        }
    }

    private void tagNodeFontSize(CriusData criusData) {
        boolean z;
        RuntimeException runtimeException;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, this, criusData) != null) || criusData == null) {
            return;
        }
        try {
            if (TextUtils.equals("text", criusData.type) && criusData.criusNode != null && criusData.fontSizes != null && criusData.fontSizes.length > 0 && (criusData.criusNode.getData() instanceof CriusTextView) && this.canReuse && this.rootView != null && (this.rootView instanceof CriusLayout)) {
                ((CriusLayout) this.rootView).invalidate((CriusTextView) criusData.criusNode.getData());
            }
            if (criusData.children == null) {
                return;
            }
            int size = criusData.children.size();
            for (int i = 0; i < size; i++) {
                tagNodeFontSize(criusData.children.get(i));
            }
        } finally {
            if (!z) {
            }
        }
    }

    private void updatePrefixLabelPos(@NonNull CriusData criusData, int i) {
        CriusData prefixLabel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65554, this, criusData, i) == null) && (prefixLabel = criusData.getPrefixLabel()) != null && prefixLabel.criusNode != null) {
            Paint paint = new Paint();
            paint.setTextSize(DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), (float) criusData.fontSize()));
            paint.measureText(criusData.text);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float layoutY = criusData.criusNode.getLayoutY() + i;
            float f = fontMetrics.ascent;
            float layoutHeight = layoutY + f + (((fontMetrics.descent - f) - prefixLabel.criusNode.getLayoutHeight()) / 2.0f);
            View view2 = null;
            if (prefixLabel.hasUI()) {
                view2 = prefixLabel.getUI().getView();
            } else if (this.idToView.get(criusData.preLabelAttrs.bindingId) != null) {
                view2 = this.idToView.get(criusData.preLabelAttrs.bindingId);
            }
            if (view2 != null) {
                view2.setX(criusData.criusNode.getLayoutX());
                if (layoutHeight >= 0.0f) {
                    view2.setY(layoutHeight);
                }
            }
        }
    }

    public void changeFontSize(Context context, boolean z, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || i == CriusData.fontLevel) {
            return;
        }
        this.canReuse = true;
        initCriusView(context, this.criusData, z, z2, i);
    }

    public ViewGroup initCriusView(Context context, CriusData criusData, boolean z, boolean z2, int i) {
        InterceptResult invokeCommon;
        boolean z3;
        RuntimeException runtimeException;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, criusData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)})) == null) {
            CriusData criusData2 = this.criusData;
            if (criusData == criusData2) {
                this.canReuse = true;
            } else {
                this.canReuse = canReuse(criusData, criusData2);
            }
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (viewGroup instanceof CriusLayout) && criusData != null && criusData != this.criusData && this.canReuse && !checkDataInCriusLayout((CriusLayout) viewGroup, criusData)) {
                this.canReuse = false;
            }
            if (criusData.currentFontLevel != i || i != CriusData.fontLevel) {
                CriusData.fontLevel = i;
                tagNodeFontSize(criusData);
            }
            CriusData.fontLevel = i;
            criusData.currentFontLevel = i;
            if (this.rootView == null || !this.canReuse) {
                this.rootView = (ViewGroup) criusData.createView(context);
            }
            this.criusData = criusData;
            try {
                recursiveRenderChildren(context, criusData, this.rootView, z, z2);
            } finally {
                if (z3) {
                }
                return this.rootView;
            }
            return this.rootView;
        }
        return (ViewGroup) invokeCommon.objValue;
    }

    public void setNightMode(Context context, boolean z, boolean z2) {
        boolean z3;
        RuntimeException runtimeException;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            try {
                this.canReuse = true;
                initCriusView(context, this.criusData, z, z2, CriusData.fontLevel);
            } finally {
                if (!z3) {
                }
            }
        }
    }
}
