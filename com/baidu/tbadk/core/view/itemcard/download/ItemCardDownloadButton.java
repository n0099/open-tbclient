package com.baidu.tbadk.core.view.itemcard.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.base.BdPageContextSupport;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DownloadManagerActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.tieba.gf7;
import com.baidu.tieba.l75;
import com.baidu.tieba.m9;
import com.baidu.tieba.on5;
import com.baidu.tieba.sy6;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.tieba.xa5;
import com.baidu.tieba.ya5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class ItemCardDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public e B;
    public PermissionJudgePolicy C;
    public BdUniqueId D;
    public boolean E;
    public d F;
    public TbDownloadManager G;
    public final CustomMessageListener H;
    public boolean a;
    public String b;
    public int c;
    public int d;
    public Paint e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public ItemData w;
    public DownloadData x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public interface e {
        void onClick(int i);
    }

    /* loaded from: classes4.dex */
    public class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ c b;

            public a(c cVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ItemCardHelper.g(2, this.a, this.b.a.w.itemId);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DownloadManagerActivityConfig(this.b.a.getContext(), 3)));
                }
            }
        }

        public c(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.x == null) {
                return;
            }
            if (this.a.v == 2 || this.a.v == 1) {
                String simpleName = ((Activity) this.a.getContext()).getClass().getSimpleName();
                if (!"DownloadManagerActivity".equals(simpleName) && SharedPrefHelper.getInstance().getBoolean("key_download_manager_first_toast", true)) {
                    SharedPrefHelper.getInstance().putBoolean("key_download_manager_first_toast", false);
                    ItemCardHelper.g(1, simpleName, this.a.w.itemId);
                    ScreenTopToast screenTopToast = new ScreenTopToast(this.a.getContext());
                    screenTopToast.m(this.a.getContext().getString(R.string.item_first_use_download_manager_toast));
                    screenTopToast.k(this.a.getContext().getString(R.string.dialog_confirm_see));
                    screenTopToast.j(new a(this, simpleName));
                    screenTopToast.o((ViewGroup) ((Activity) this.a.getContext()).findViewById(16908290));
                }
            }
            if ((this.a.x.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) this.a.x.getExtra()).isShouzhuData()) {
                if (this.a.v == 5) {
                    ya5.a(this.a.x, 500);
                    xa5.f().d(this.a.w, this.a.x, this.a.y, this.a.D);
                    return;
                }
                ya5.a(this.a.x, 200);
                xa5.f().e(this.a.w, this.a.x, this.a.y, this.a.D);
                return;
            }
            on5.m(this.a.x);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemCardDownloadButton a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ItemCardDownloadButton itemCardDownloadButton, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.x == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (!this.a.w.pkgName.equals(on5.g((Intent) data))) {
                    return;
                }
                this.a.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ItemCardDownloadButton b;

        public b(ItemCardDownloadButton itemCardDownloadButton, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = itemCardDownloadButton;
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BdPageContext<?> a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (a = m9.a(this.a)) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(a)) {
                return;
            }
            if (this.b.v == 0) {
                if (this.b.A != null) {
                    this.b.A.onClick(view2);
                    return;
                }
                return;
            }
            this.b.p();
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements gf7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ItemCardDownloadButton> a;

        public d(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(itemCardDownloadButton);
        }

        @Override // com.baidu.tieba.gf7
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
                g(downloadData, downloadData.getProcess(), 5);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                g(downloadData, 100, 3);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
                g(downloadData, downloadData.getProcess(), 5);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                g(downloadData, 0, 0);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
                g(downloadData, downloadData.getProcess(), 4);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void f(@NonNull DownloadData downloadData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
                g(downloadData, Math.max(downloadData.getProcess(), 0), 4);
            }
        }

        public final void g(@NonNull DownloadData downloadData, int i, int i2) {
            ItemCardDownloadButton itemCardDownloadButton;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLII(1048582, this, downloadData, i, i2) != null) || (itemCardDownloadButton = this.a.get()) == null || itemCardDownloadButton.x == null || itemCardDownloadButton.x.getId() == null || !itemCardDownloadButton.x.getId().equals(downloadData.getId())) {
                return;
            }
            itemCardDownloadButton.c = i;
            itemCardDownloadButton.v = i2;
            itemCardDownloadButton.x();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.w == null) {
                return;
            }
            if (this.v == 6 && this.t) {
                n(canvas);
                return;
            }
            int i = this.v;
            if ((i == 0 || i == 1 || i == 2 || i == 6) && this.r == 0) {
                m(canvas);
            } else {
                o(canvas);
            }
        }
    }

    public final boolean q(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadData)) == null) {
            int c2 = on5.c(downloadData);
            int h = on5.h(downloadData);
            this.c = h;
            if (c2 != 5 && c2 != 1) {
                if ((h > 0 && h <= 100) || (this.c == 0 && c2 == 7)) {
                    this.v = 5;
                    return true;
                }
                return false;
            }
            this.v = 4;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean t(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, itemData)) == null) {
            PackageInfo e2 = on5.e(itemData.pkgName);
            int i = 0;
            if (e2 == null || e2.versionCode >= itemData.apkDetail.version_code.intValue()) {
                return false;
            }
            this.v = 2;
            if (this.r != 0) {
                i = 100;
            }
            this.c = i;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            Paint paint = new Paint(1);
            this.e = paint;
            paint.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.T_X08));
            this.g = BdUtilHelper.getDimens(getContext(), R.dimen.L_X01);
            v();
            setOnClickListener(new b(this, context));
            this.F = new d(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void setCustomColorBtn(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.r = i;
            if (z) {
                if (i == 0) {
                    this.e.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.T_X08));
                } else {
                    this.e.setTextSize(BdUtilHelper.getDimens(getContext(), R.dimen.T_X07));
                }
            }
            v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context, AttributeSet attributeSet, int i) {
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
        this.d = 0;
        this.t = false;
        this.u = false;
        this.D = BdUniqueId.gen();
        this.E = false;
        this.H = new a(this, 2002504);
        u(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    this.a = false;
                    postInvalidate();
                }
            } else {
                this.a = true;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean r(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, downloadData)) == null) {
            if (on5.b(downloadData)) {
                this.v = 3;
                this.c = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(@NonNull ItemData itemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, itemData)) == null) {
            PackageInfo e2 = on5.e(itemData.pkgName);
            if (e2 != null && e2.versionCode >= itemData.apkDetail.version_code.intValue()) {
                this.v = 6;
                this.c = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.B = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.A = onClickListener;
        }
    }

    public void setCustomColorBtn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i == Integer.MAX_VALUE) {
                if (this.d == 4) {
                    i = SkinManager.getColor(R.color.CAM_X0209);
                } else {
                    i = SkinManager.getColor(R.color.CAM_X0303);
                }
            }
            setCustomColorBtn(i, true);
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdUniqueId) == null) {
            this.D = bdUniqueId;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.z = str;
            x();
        }
    }

    public void setUserProgressTextGradientModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.E = z;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.u = true;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t = true;
            postInvalidate();
        }
    }

    public ItemData getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.w;
        }
        return (ItemData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public BdUniqueId getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            y();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            z();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (getContext() instanceof BdPageContextSupport) {
                ((BdPageContextSupport) getContext()).getPageContext().registerListener(this.H);
            }
            TbDownloadManager tbDownloadManager = this.G;
            if (tbDownloadManager != null) {
                tbDownloadManager.g(this.F);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.H);
            TbDownloadManager tbDownloadManager = this.G;
            if (tbDownloadManager != null) {
                tbDownloadManager.u(this.F);
            }
        }
    }

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            switch (this.v) {
                case 1:
                    if (ItemCardHelper.b.equals(this.w.buttonName)) {
                        return 2;
                    }
                    if (!ItemCardHelper.c.equals(this.w.buttonName)) {
                        return -1;
                    }
                    return 10;
                case 2:
                    return 6;
                case 3:
                    return 4;
                case 4:
                    return 8;
                case 5:
                    return 7;
                case 6:
                    return 5;
                default:
                    return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.C == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.C = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new c(this));
            }
            if (getContext() instanceof Activity) {
                this.C.clearRequestPermissionList();
                this.C.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.C.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void m(Canvas canvas) {
        float f;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            this.e.setColor(this.f);
            Paint paint = this.e;
            if (this.a) {
                f = SkinManager.RESOURCE_ALPHA_PRESS * 255.0f;
            } else {
                f = 255.0f;
            }
            paint.setAlpha((int) (f * 0.5f));
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setStrokeWidth(this.g);
            this.e.setShadowLayer(this.q, this.o, this.p, this.n);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.f);
            Paint paint2 = this.e;
            if (this.a) {
                i = (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f);
            } else {
                i = 255;
            }
            paint2.setAlpha(i);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            float f2 = fontMetrics.top;
            canvas.drawText(this.b, getWidth() >> 1, ((int) ((getHeight() - f2) - fontMetrics.bottom)) >> 1, this.e);
        }
    }

    public final void n(Canvas canvas) {
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            int i = 255;
            if (this.r != 0) {
                this.e.setColor(this.s);
                this.e.setAlpha(255);
                this.e.setStyle(Paint.Style.FILL_AND_STROKE);
                this.e.setShadowLayer(this.q, this.o, this.p, this.n);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
                this.e.clearShadowLayer();
            }
            if (this.d == 4) {
                Paint paint = this.e;
                if (this.a) {
                    f3 = SkinManager.RESOURCE_ALPHA_PRESS * 255.0f;
                } else {
                    f3 = 255.0f;
                }
                paint.setAlpha((int) (f3 * 0.5f));
            } else {
                Paint paint2 = this.e;
                if (this.a) {
                    f = SkinManager.RESOURCE_ALPHA_PRESS * 255.0f;
                } else {
                    f = 255.0f;
                }
                paint2.setAlpha((int) (f * 0.25f));
            }
            this.e.setColor(this.k);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setStrokeWidth(this.g);
            this.e.setShadowLayer(this.q, this.o, this.p, this.n);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.j);
            Paint paint3 = this.e;
            if (this.a) {
                f2 = SkinManager.RESOURCE_ALPHA_PRESS * 255.0f;
            } else {
                f2 = 255.0f;
            }
            paint3.setAlpha((int) (f2 * 0.5f));
            this.e.setStyle(Paint.Style.FILL);
            this.e.setStrokeWidth(this.g);
            this.e.setShadowLayer(this.q, this.o, this.p, this.n);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.clearShadowLayer();
            this.e.setColor(this.l);
            Paint paint4 = this.e;
            if (this.a) {
                i = (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f);
            }
            paint4.setAlpha(i);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            float f4 = fontMetrics.top;
            canvas.drawText(this.b, getWidth() >> 1, ((int) ((getHeight() - f4) - fontMetrics.bottom)) >> 1, this.e);
        }
    }

    public final void o(Canvas canvas) {
        float f;
        int i;
        float f2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            int i3 = 255;
            if (this.r != 0) {
                this.e.setColor(this.s);
                this.e.setAlpha(255);
                this.e.setStyle(Paint.Style.FILL_AND_STROKE);
                this.e.setShadowLayer(this.q, this.o, this.p, this.n);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
                this.e.clearShadowLayer();
            }
            int width = (getWidth() * this.c) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.e.setColor(this.i);
            Paint paint = this.e;
            if (this.a) {
                f = SkinManager.RESOURCE_ALPHA_PRESS * 255.0f;
            } else {
                f = 255.0f;
            }
            paint.setAlpha((int) (f * 0.08f));
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.setColor(this.i);
            Paint paint2 = this.e;
            if (this.a) {
                i = (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f);
            } else {
                i = 255;
            }
            paint2.setAlpha(i);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.e.setColor(this.i);
            Paint paint3 = this.e;
            if (this.a) {
                f2 = SkinManager.RESOURCE_ALPHA_PRESS * 255.0f;
            } else {
                f2 = 255.0f;
            }
            paint3.setAlpha((int) f2);
            this.e.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.e);
            this.e.setColor(this.h);
            Paint paint4 = this.e;
            if (this.a) {
                i2 = (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f);
            } else {
                i2 = 255;
            }
            paint4.setAlpha(i2);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            canvas.restore();
            if (this.d != 0 && !this.E) {
                this.e.setColor(this.h);
                Paint paint5 = this.e;
                if (this.a) {
                    i3 = (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f);
                }
                paint5.setAlpha(i3);
                this.e.setStyle(Paint.Style.FILL);
                this.e.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.b, getWidth() >> 1, height, this.e);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            e eVar = this.B;
            if (eVar != null) {
                eVar.onClick(this.v);
            }
            switch (this.v) {
                case 1:
                case 2:
                    DownloadData downloadData = this.x;
                    if (downloadData == null || !sy6.e(downloadData.getSource())) {
                        sy6 sy6Var = new sy6();
                        sy6Var.a = this.w;
                        sy6Var.b = 1;
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921627, sy6Var));
                    }
                    l();
                    return;
                case 3:
                    on5.j(this.x);
                    return;
                case 4:
                    on5.a(this.x);
                    return;
                case 5:
                    l();
                    return;
                case 6:
                    ya5.a(this.x, 1000);
                    on5.l(this.w.pkgName);
                    return;
                default:
                    return;
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.d = TbadkCoreApplication.getInst().getSkinType();
            this.j = SkinManager.getColor(R.color.CAM_X0209);
            if (this.d == 4) {
                this.k = SkinManager.getColor(R.color.CAM_X0209);
                this.l = SkinManager.getColor(R.color.CAM_X0103);
            } else {
                int i = this.r;
                if (i != 0) {
                    this.l = i;
                    this.k = i;
                } else {
                    this.l = SkinManager.getColor(R.color.CAM_X0304);
                    this.k = SkinManager.getColor(R.color.CAM_X0304);
                }
            }
            this.n = SkinManager.getColor(this.m);
            this.f = SkinManager.getColor(R.color.CAM_X0304);
            this.i = SkinManager.getColor(R.color.CAM_X0303);
            this.h = SkinManager.getColor(R.color.CAM_X0101);
            this.s = SkinManager.getColor(R.color.CAM_X0201);
            int i2 = this.r;
            if (i2 != 0) {
                this.f = i2;
                this.i = i2;
            }
            postInvalidate();
        }
    }

    public void setData(@NonNull ItemData itemData, int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{itemData, Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            this.w = itemData;
            this.y = str;
            int i3 = 0;
            if (!ItemCardHelper.x(itemData)) {
                this.v = 0;
                if (this.r != 0) {
                    i3 = 100;
                }
                this.c = i3;
                this.x = null;
            } else {
                DownloadData k = on5.k(itemData);
                this.x = k;
                if (this.G == null) {
                    this.G = on5.i(k);
                }
                this.x.setSource(i2);
                if (itemData != null && StringUtils.isNotNull(itemData.pkgName)) {
                    ApkDownloadData apkDownloadData = new ApkDownloadData();
                    apkDownloadData.setPackageName(itemData.pkgName);
                    this.x.setApkDownloadData(apkDownloadData);
                }
                if (this.x.getExtra() instanceof ItemDownloadExtraData) {
                    ((ItemDownloadExtraData) this.x.getExtra()).updateSceneCategory(i);
                }
                if (!s(itemData) && !t(itemData) && !r(this.x) && !q(this.x)) {
                    this.v = 1;
                    if (this.r != 0) {
                        i3 = 100;
                    }
                    this.c = i3;
                }
            }
            x();
            v();
            ya5.a(this.x, 100);
        }
    }

    public void setShadow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            String[] I = l75.I(i);
            int identifier = TbadkCoreApplication.getInst().getResources().getIdentifier(I[0], "color", TbadkCoreApplication.getInst().getPackageName());
            this.m = identifier;
            this.n = SkinManager.getColor(identifier);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            Resources resources2 = TbadkCoreApplication.getInst().getResources();
            this.q = resources.getDimensionPixelSize(resources2.getIdentifier("tbds" + I[1], EMABTest.TYPE_DIMEN, TbadkCoreApplication.getInst().getPackageName()));
            String[] split = I[2].split(",");
            Resources resources3 = TbadkCoreApplication.getInst().getResources();
            Resources resources4 = TbadkCoreApplication.getInst().getResources();
            this.o = resources3.getDimensionPixelSize(resources4.getIdentifier("tbds" + split[0], EMABTest.TYPE_DIMEN, TbadkCoreApplication.getInst().getPackageName()));
            Resources resources5 = TbadkCoreApplication.getInst().getResources();
            Resources resources6 = TbadkCoreApplication.getInst().getResources();
            this.p = resources5.getDimensionPixelSize(resources6.getIdentifier("tbds" + split[1], EMABTest.TYPE_DIMEN, TbadkCoreApplication.getInst().getPackageName()));
            postInvalidate();
        }
    }

    public final void w() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (!s(this.w) && !t(this.w) && !r(this.x) && !q(this.x)) {
                this.v = 1;
                if (this.r == 0) {
                    i = 0;
                } else {
                    i = 100;
                }
                this.c = i;
            }
            x();
        }
    }

    public final void x() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            int i = this.v;
            if (i != 0) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    this.b = this.w.buttonName;
                                } else {
                                    this.b = getResources().getString(R.string.item_download_open);
                                }
                            } else if (!this.u) {
                                this.b = getResources().getString(R.string.item_download_pause);
                            } else {
                                this.b = getResources().getString(R.string.go_on_download);
                            }
                        } else {
                            this.b = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.c));
                        }
                    } else {
                        this.b = getResources().getString(R.string.item_download_install);
                    }
                } else {
                    this.b = getResources().getString(R.string.item_download_update);
                }
            } else {
                if (TextUtils.isEmpty(this.z)) {
                    str = this.w.buttonName;
                } else {
                    str = this.z;
                }
                this.b = str;
            }
            postInvalidate();
        }
    }
}
