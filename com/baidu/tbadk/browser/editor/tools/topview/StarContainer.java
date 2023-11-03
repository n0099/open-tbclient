package com.baidu.tbadk.browser.editor.tools.topview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.browser.editor.tools.topview.StarContainer;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.dh5;
import com.baidu.tieba.dj6;
import com.baidu.tieba.le5;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.xd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\u0012\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016J0\u0010+\u001a\u00020!2&\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u0015H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/baidu/tbadk/browser/editor/tools/topview/StarContainer;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tbadk/editortools/ToolViewInterface;", "Lcom/baidu/tbadk/editortools/topview/IToolData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBackground", "Landroid/view/View;", "mCloseView", "Landroid/widget/ImageView;", "mData", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "mET", "Lcom/baidu/tbadk/editortools/EditorTools;", "mHeadPhotoBackGround", "mHeadPhotoView", "Lcom/baidu/tbadk/core/view/HeadImageView;", "mNameView", "Landroid/widget/TextView;", "mRankStarView", "Lcom/baidu/tbadk/widget/RankStarView;", "mRootLayout", "Landroid/widget/LinearLayout;", "mUserName", CriusAttrConstants.DISPLAY, "", "getToolId", "hide", "init", "onAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "sendAction", "setData", "data", "setEditorTools", "et", "setToolId", "id", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StarContainer extends FrameLayout implements le5, dh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public HashMap<String, Object> b;
    public String c;
    public final View d;
    public final LinearLayout e;
    public final HeadImageView f;
    public final View g;
    public final ImageView h;
    public final TextView i;
    public final RankStarView j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StarContainer(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StarContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.le5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.le5
    public void g0(xd5 action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
        }
    }

    @Override // com.baidu.tieba.le5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.le5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.le5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.le5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StarContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNull(context);
        this.d = new View(getContext());
        this.e = new LinearLayout(getContext());
        this.f = new HeadImageView(getContext());
        this.g = new View(getContext());
        this.h = new ImageView(getContext());
        this.i = new EMTextView(getContext());
        this.j = new RankStarView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.tbds370));
        layoutParams.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds39);
        addView(this.d, layoutParams);
        this.e.setOrientation(1);
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.e.setGravity(1);
        this.e.setBackgroundColor(0);
        addView(this.e);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.e.addView(frameLayout, new FrameLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds188), BdUtilHelper.getDimens(getContext(), R.dimen.tbds188)));
        frameLayout.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f.setPlaceHolder(1);
        this.f.setRadiusById(R.string.J_X04);
        this.f.setDrawBorder(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds178), BdUtilHelper.getDimens(getContext(), R.dimen.tbds178));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.f, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds105), BdUtilHelper.getDimens(getContext(), R.dimen.tbds105));
        layoutParams3.leftMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds16);
        layoutParams3.topMargin = BdUtilHelper.getDimens(getContext(), R.dimen.tbds46);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kt4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    StarContainer.a(StarContainer.this, view2);
                }
            }
        });
        addView(this.h, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        this.i.setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds30), 0, 0);
        this.e.addView(this.i, layoutParams4);
        this.j.setPadding(0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X006), 0, 0);
        this.j.setStarSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.tbds28));
        this.j.setFullStarColorListIndex(0, ColorUtils.parseColor("#FFA02B"));
        this.j.setFullStarColorListIndex(1, ColorUtils.parseColor("#FF962B"));
        this.j.setFullStarColorListIndex(2, ColorUtils.parseColor("#FF8C2B"));
        this.j.setFullStarColorListIndex(3, ColorUtils.parseColor("#FF842B"));
        this.j.setFullStarColorListIndex(4, ColorUtils.parseColor("#FF7C2B"));
        this.j.setClickable(true);
        this.e.addView(this.j, new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds112)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public /* synthetic */ StarContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final void a(StarContainer this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            EditorTools editorTools = this$0.a;
            if (editorTools != null) {
                editorTools.v();
            }
        }
    }

    @Override // com.baidu.tieba.yd5
    public void S(xd5 xd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, xd5Var) == null) && xd5Var != null && xd5Var.a == 8) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("newValue", this.j.getStarCount());
                jSONObject.put("playerName", this.c);
                dj6.a().h("gameCard.playerInfoStar", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tieba.le5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            EMManager.from(this.d).setShadow(R.array.S_O_X006).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0207);
            EMManager.from(this.g).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0207);
            this.h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            EMManager.from(this.i).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05);
            this.j.f(i);
        }
    }

    @Override // com.baidu.tieba.dh5
    public void setData(HashMap<String, Object> hashMap) {
        String str;
        String obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            if (hashMap == null) {
                setVisibility(8);
                return;
            }
            this.b = hashMap;
            Object obj2 = hashMap.get("portrait");
            Object obj3 = hashMap.get(TbEnum.SystemMessage.KEY_USER_NAME);
            if (obj3 != null) {
                str = obj3.toString();
            } else {
                str = null;
            }
            this.c = str;
            Object obj4 = hashMap.get("star");
            if (obj2 != null && (obj = obj2.toString()) != null) {
                this.f.startLoad(obj, 12, false);
            }
            String str2 = this.c;
            if (str2 != null) {
                this.i.setText(str2);
            }
            this.j.setStarCount(JavaTypesHelper.toFloat(String.valueOf(obj4), 0.0f));
        }
    }

    @Override // com.baidu.tieba.le5
    public void setEditorTools(EditorTools et) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, et) == null) {
            Intrinsics.checkNotNullParameter(et, "et");
            this.a = et;
        }
    }
}
