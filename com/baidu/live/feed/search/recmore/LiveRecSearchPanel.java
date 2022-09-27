package com.baidu.live.feed.search.recmore;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.feed.search.recmore.ILiveRecSearchPanel;
import com.baidu.live.feed.search.view.LiveSearchPanel;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.va0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b:\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\u00102\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00102\b\b\u0001\u0010\u001d\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J)\u0010&\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u00022\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010 \u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u00102\b\b\u0001\u0010\u001d\u001a\u00020\u0015H\u0016¢\u0006\u0004\b.\u0010\u0018J\u0019\u00100\u001a\u00020\u00102\b\b\u0001\u0010/\u001a\u00020\u0015H\u0016¢\u0006\u0004\b0\u0010\u0018J\u0017\u00103\u001a\u00020\u00102\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/baidu/live/feed/search/recmore/LiveRecSearchPanel;", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel;", "", "getCurrentQueryHint", "()Ljava/lang/String;", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "getText", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/content/Context;", "context", "onCreate", "(Landroid/content/Context;)Landroid/view/View;", "", MissionEvent.MESSAGE_DESTROY, "()V", "requestInput", "resetView", "", UriUtil.LOCAL_RESOURCE_SCHEME, "setBackgroundResource", "(I)V", "", "editable", "setEditable", "(Z)V", "color", "setHintTextColor", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnEditClickListener", "(Landroid/view/View$OnClickListener;)V", "curShowHint", "", "hintList", "setQueryHintList", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel$OnSearchPanelListener;", "setQueryListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel$OnSearchPanelListener;)V", "editText", "setText", "(Ljava/lang/String;)V", "setTextColor", "textCursorDrawable", "setTextCursorDrawable", "", "pxValue", "setTextSize", "(F)V", "searchListener", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel$OnSearchPanelListener;", "Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "searchPanel", "Lcom/baidu/live/feed/search/view/LiveSearchPanel;", "<init>", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveRecSearchPanel implements ILiveRecSearchPanel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ILiveRecSearchPanel.OnSearchPanelListener searchListener;
    public LiveSearchPanel searchPanel;

    public LiveRecSearchPanel() {
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

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public String getCurrentQueryHint() {
        InterceptResult invokeV;
        String currentQueryHint;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LiveSearchPanel liveSearchPanel = this.searchPanel;
            return (liveSearchPanel == null || (currentQueryHint = liveSearchPanel.getCurrentQueryHint()) == null) ? "" : currentQueryHint;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public EditText getEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LiveSearchPanel liveSearchPanel = this.searchPanel;
            if (liveSearchPanel != null) {
                return liveSearchPanel.getEditText();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public String getText() {
        InterceptResult invokeV;
        String text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LiveSearchPanel liveSearchPanel = this.searchPanel;
            return (liveSearchPanel == null || (text = liveSearchPanel.getText()) == null) ? "" : text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.searchPanel : (View) invokeV.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public View onCreate(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            LiveSearchPanel liveSearchPanel = new LiveSearchPanel(context, null, 0, 6, null);
            liveSearchPanel.setScene("recommend");
            liveSearchPanel.getSearchTag().setVisibility(0);
            liveSearchPanel.getSplitLineView().setVisibility(8);
            liveSearchPanel.getSearchDoneBtn().setVisibility(8);
            liveSearchPanel.setQueryListener(new LiveSearchPanel.g(this) { // from class: com.baidu.live.feed.search.recmore.LiveRecSearchPanel$onCreate$$inlined$apply$lambda$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LiveRecSearchPanel this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.searchListener;
                 */
                @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onCancelClick() {
                    ILiveRecSearchPanel.OnSearchPanelListener onSearchPanelListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || onSearchPanelListener == null) {
                        return;
                    }
                    onSearchPanelListener.onCancelClick();
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.searchListener;
                 */
                @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onQueryTextChange(String str) {
                    ILiveRecSearchPanel.OnSearchPanelListener onSearchPanelListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || onSearchPanelListener == null) {
                        return;
                    }
                    onSearchPanelListener.onQueryTextChange(str);
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                    r0 = r4.this$0.searchListener;
                 */
                @Override // com.baidu.live.feed.search.view.LiveSearchPanel.g
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onQueryTextSubmit(String str) {
                    ILiveRecSearchPanel.OnSearchPanelListener onSearchPanelListener;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || onSearchPanelListener == null) {
                        return;
                    }
                    onSearchPanelListener.onQueryTextSubmit(str);
                }
            });
            this.searchPanel = liveSearchPanel;
            return liveSearchPanel;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void onDestroy() {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.j();
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void requestInput() {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.m();
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void resetView() {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.n();
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setBackgroundResource(@DrawableRes int i) {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.setBackgroundResource(i);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setEditable(boolean z) {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.setEditable(z);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setHintTextColor(@ColorInt int i) {
        LiveSearchPanel liveSearchPanel;
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (liveSearchPanel = this.searchPanel) == null || (editText = liveSearchPanel.getEditText()) == null) {
            return;
        }
        editText.setHintTextColor(i);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setOnEditClickListener(View.OnClickListener onClickListener) {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.setOnEditClickListener(onClickListener);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setQueryHintList(String str, List<String> list) {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, list) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        liveSearchPanel.setQueryHintList(str, list);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setQueryListener(ILiveRecSearchPanel.OnSearchPanelListener onSearchPanelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSearchPanelListener) == null) {
            this.searchListener = onSearchPanelListener;
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setText(String str) {
        LiveSearchPanel liveSearchPanel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || (liveSearchPanel = this.searchPanel) == null) {
            return;
        }
        if (str == null) {
            str = "";
        }
        liveSearchPanel.setText(str);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setTextColor(@ColorInt int i) {
        LiveSearchPanel liveSearchPanel;
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || (liveSearchPanel = this.searchPanel) == null || (editText = liveSearchPanel.getEditText()) == null) {
            return;
        }
        editText.setTextColor(i);
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setTextCursorDrawable(@DrawableRes int i) {
        EditText editText;
        EditText editText2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                LiveSearchPanel liveSearchPanel = this.searchPanel;
                if (liveSearchPanel == null || (editText2 = liveSearchPanel.getEditText()) == null) {
                    return;
                }
                editText2.setTextCursorDrawable(i);
                return;
            }
            LiveSearchPanel liveSearchPanel2 = this.searchPanel;
            if (liveSearchPanel2 == null || (editText = liveSearchPanel2.getEditText()) == null) {
                return;
            }
            va0.a(editText, i);
        }
    }

    @Override // com.baidu.live.feed.search.recmore.ILiveRecSearchPanel
    public void setTextSize(float f) {
        LiveSearchPanel liveSearchPanel;
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048593, this, f) == null) || (liveSearchPanel = this.searchPanel) == null || (editText = liveSearchPanel.getEditText()) == null) {
            return;
        }
        editText.setTextSize(0, f);
    }
}
