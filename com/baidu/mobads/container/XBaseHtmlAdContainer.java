package com.baidu.mobads.container;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler;
import com.baidu.mobads.container.bridge.ExpandedLayout;
import com.baidu.mobads.container.util.AdResource;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class XBaseHtmlAdContainer extends XBaseAdContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XBaseHtmlAdContainer";
    public transient /* synthetic */ FieldHolder $fh;
    public ExpandedLayout.OnCloseListener expandCloseListener;
    public ExpandedLayout expandedLayout;
    public BaseHtmlBridgeHandler mBridgeHandler;
    public ViewGroup mRootView;
    public XMyWebView mWebView;
    public boolean shouldUseCustomUse;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XBaseHtmlAdContainer(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((XAdContainerContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.expandCloseListener = new ExpandedLayout.OnCloseListener(this) { // from class: com.baidu.mobads.container.XBaseHtmlAdContainer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XBaseHtmlAdContainer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.bridge.ExpandedLayout.OnCloseListener
            public void onClose() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.closeExpand();
                }
            }
        };
    }

    @TargetApi(19)
    private ViewGroup getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mRootView == null) {
                if (Build.VERSION.SDK_INT >= 19 && !this.mAdContainerCxt.getAdProdBase().isAttachedToWindow()) {
                    return null;
                }
                this.mRootView = (ViewGroup) this.mAdContainerCxt.getAdProdBase().getRootView().findViewById(16908290);
            }
            return this.mRootView;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void closeExpand() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                getRootView().removeView(this.expandedLayout);
                this.expandedLayout.removeAllViews();
                this.expandedLayout = null;
                this.mAdContainerCxt.getAdProdBase().addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
                this.mBridgeHandler.expandCloseSuccess();
            } catch (Exception e2) {
                this.mAdLogger.d(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void destroy() {
        XMyWebView xMyWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (xMyWebView = this.mWebView) == null) {
            return;
        }
        xMyWebView.destroy();
    }

    public BaseHtmlBridgeHandler getBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBridgeHandler : (BaseHtmlBridgeHandler) invokeV.objValue;
    }

    public XMyWebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mWebView : (XMyWebView) invokeV.objValue;
    }

    public void handleExpand(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            try {
                if (getRootView() == null) {
                    return;
                }
                ExpandedLayout expandedLayout = new ExpandedLayout(this.mAppContext, AdResource.getInterstitialVideoClose());
                this.expandedLayout = expandedLayout;
                expandedLayout.setOnCloseListener(this.expandCloseListener);
                this.mAdContainerCxt.getAdProdBase().removeView(this.mWebView);
                this.expandedLayout.addView(this.mWebView, new FrameLayout.LayoutParams(-1, -1));
                getRootView().addView(this.expandedLayout, new ViewGroup.LayoutParams(-1, -1));
                this.expandedLayout.setKeyDownListener(new ExpandedLayout.KeyDownListener(this) { // from class: com.baidu.mobads.container.XBaseHtmlAdContainer.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XBaseHtmlAdContainer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.mobads.container.bridge.ExpandedLayout.KeyDownListener
                    public boolean handleKeyDown(int i2, KeyEvent keyEvent) {
                        InterceptResult invokeIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(1048576, this, i2, keyEvent)) == null) {
                            Boolean valueOf = Boolean.valueOf(i2 == 4);
                            if (valueOf.booleanValue()) {
                                this.this$0.closeExpand();
                            }
                            return valueOf.booleanValue();
                        }
                        return invokeIL.booleanValue;
                    }
                });
                this.expandedLayout.setFocusableInTouchMode(true);
                this.expandedLayout.setFocusable(true);
                this.expandedLayout.requestFocus();
                this.mBridgeHandler.expandSuccess();
            } catch (Exception e2) {
                this.mAdLogger.d(e2);
            }
        }
    }

    public void handleUseCustomClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            try {
                this.shouldUseCustomUse = z;
                if (this.expandedLayout != null) {
                    this.expandedLayout.setCloseVisible(!z);
                }
            } catch (Exception e2) {
                this.mAdLogger.d(e2);
            }
        }
    }

    public abstract void initBridgeHandler();
}
