package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.g;
import c.a.e.e.p.l;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.Item;
/* loaded from: classes6.dex */
public class ItemCardDownloadButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47432e;

    /* renamed from: f  reason: collision with root package name */
    public String f47433f;

    /* renamed from: g  reason: collision with root package name */
    public int f47434g;

    /* renamed from: h  reason: collision with root package name */
    public int f47435h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f47436i;

    /* renamed from: j  reason: collision with root package name */
    public int f47437j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public Item q;
    public DownloadData r;
    public String s;
    public View.OnClickListener t;
    public e u;
    public PermissionJudgePolicy v;
    public final CustomMessageListener w;
    public final CustomMessageListener x;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47438a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ItemCardDownloadButton itemCardDownloadButton, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47438a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f47438a.r != null && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (this.f47438a.r.getId().equals(downloadData.getId())) {
                        int status = downloadData.getStatus();
                        if (status == 1) {
                            this.f47438a.f47434g = downloadData.getProcess();
                            this.f47438a.p = 4;
                        } else if (status == 2 || status == 4) {
                            this.f47438a.f47434g = downloadData.getProcess();
                            this.f47438a.r.setStatus(7);
                            this.f47438a.p = 5;
                        } else if (status != 5) {
                            this.f47438a.s();
                        } else {
                            ItemCardDownloadButton itemCardDownloadButton = this.f47438a;
                            itemCardDownloadButton.f47434g = c.a.o0.d0.a.g(itemCardDownloadButton.r);
                            this.f47438a.p = 4;
                        }
                        this.f47438a.t();
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47439a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ItemCardDownloadButton itemCardDownloadButton, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47439a = itemCardDownloadButton;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f47439a.r == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                if (this.f47439a.q.apk_name.equals(c.a.o0.d0.a.f((Intent) data))) {
                    this.f47439a.s();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47440e;

        public c(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47440e = itemCardDownloadButton;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f47440e.p == 0) {
                    if (this.f47440e.t != null) {
                        this.f47440e.t.onClick(view);
                        return;
                    }
                    return;
                }
                this.f47440e.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ItemCardDownloadButton f47441a;

        public d(ItemCardDownloadButton itemCardDownloadButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemCardDownloadButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47441a = itemCardDownloadButton;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.d0.a.k(this.f47441a.r);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void onClick(int i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getObjTypeByDownloadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.p;
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return i2 != 6 ? -1 : 5;
                    }
                    return 2;
                }
                return 4;
            }
            return 6;
        }
        return invokeV.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.v == null) {
                PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
                this.v = permissionJudgePolicy;
                permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this));
            }
            if (getContext() instanceof Activity) {
                this.v.clearRequestPermissionList();
                this.v.appendRequestPermission((Activity) getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
                this.v.startRequestPermission((Activity) getContext());
            }
        }
    }

    public final void k(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.f47436i.setColor(this.f47437j);
            this.f47436i.setAlpha((int) ((this.f47432e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.5f));
            this.f47436i.setStyle(Paint.Style.STROKE);
            this.f47436i.setStrokeWidth(this.k);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47436i);
            this.f47436i.setColor(this.f47437j);
            this.f47436i.setAlpha(this.f47432e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47436i.setStyle(Paint.Style.FILL);
            this.f47436i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47436i.getFontMetrics();
            canvas.drawText(this.f47433f, getWidth() >> 1, ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1, this.f47436i);
        }
    }

    public final void l(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.n != 0) {
                this.f47436i.setColor(this.o);
                this.f47436i.setAlpha(255);
                this.f47436i.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47436i);
            }
            int width = (getWidth() * this.f47434g) / 100;
            canvas.save();
            canvas.clipRect(width, 0, getWidth(), getHeight());
            this.f47436i.setColor(this.m);
            this.f47436i.setAlpha((int) ((this.f47432e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f) * 0.08f));
            this.f47436i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47436i);
            this.f47436i.setColor(this.m);
            this.f47436i.setAlpha(this.f47432e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47436i.setStyle(Paint.Style.FILL);
            this.f47436i.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f47436i.getFontMetrics();
            float height = ((int) ((getHeight() - fontMetrics.top) - fontMetrics.bottom)) >> 1;
            canvas.drawText(this.f47433f, getWidth() >> 1, height, this.f47436i);
            canvas.restore();
            canvas.save();
            canvas.clipRect(0, 0, width, getHeight());
            this.f47436i.setColor(this.m);
            this.f47436i.setAlpha((int) (this.f47432e ? SkinManager.RESOURCE_ALPHA_PRESS * 255.0f : 255.0f));
            this.f47436i.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), getHeight(), getHeight(), this.f47436i);
            this.f47436i.setColor(this.l);
            this.f47436i.setAlpha(this.f47432e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
            this.f47436i.setStyle(Paint.Style.FILL);
            this.f47436i.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f47433f, getWidth() >> 1, height, this.f47436i);
            canvas.restore();
            if (this.f47435h != 0) {
                this.f47436i.setColor(this.l);
                this.f47436i.setAlpha(this.f47432e ? (int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f) : 255);
                this.f47436i.setStyle(Paint.Style.FILL);
                this.f47436i.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(this.f47433f, getWidth() >> 1, height, this.f47436i);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e eVar = this.u;
            if (eVar != null) {
                eVar.onClick(this.p);
            }
            switch (this.p) {
                case 1:
                case 2:
                case 5:
                    j();
                    return;
                case 3:
                    c.a.o0.d0.a.h(this.r);
                    return;
                case 4:
                    c.a.o0.d0.a.a(this.r);
                    return;
                case 6:
                    c.a.o0.d0.a.j(this.q.apk_name);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean n(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadData)) == null) {
            int c2 = c.a.o0.d0.a.c(downloadData);
            int g2 = c.a.o0.d0.a.g(downloadData);
            this.f47434g = g2;
            if (c2 == 5 || c2 == 1) {
                this.p = 4;
                return true;
            } else if (g2 <= 0 || g2 > 100) {
                return false;
            } else {
                this.p = 5;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean o(@NonNull DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, downloadData)) == null) {
            if (c.a.o0.d0.a.b(downloadData.getId())) {
                this.p = 3;
                this.f47434g = 100;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f47435h = TbadkCoreApplication.getInst().getSkinType();
            this.f47437j = SkinManager.getColor(R.color.CAM_X0304);
            this.m = SkinManager.getColor(R.color.CAM_X0303);
            this.l = SkinManager.getColor(R.color.CAM_X0101);
            this.o = SkinManager.getColor(R.color.CAM_X0201);
            int i2 = this.n;
            if (i2 != 0) {
                this.f47437j = i2;
                this.m = i2;
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.q == null) {
                return;
            }
            int i2 = this.p;
            if ((i2 == 0 || i2 == 1 || i2 == 2 || i2 == 6) && this.n == 0) {
                k(canvas);
            } else {
                l(canvas);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f47432e = true;
                postInvalidate();
            } else if (action == 1 || action == 3) {
                this.f47432e = false;
                postInvalidate();
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, item)) == null) {
            PackageInfo d2 = c.a.o0.d0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode < item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.p = 6;
            this.f47434g = 100;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean q(@NonNull Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, item)) == null) {
            PackageInfo d2 = c.a.o0.d0.a.d(item.apk_name);
            if (d2 == null || d2.versionCode >= item.apk_detail.version_code.intValue()) {
                return false;
            }
            this.p = 2;
            this.f47434g = this.n != 0 ? 100 : 0;
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            Paint paint = new Paint(1);
            this.f47436i = paint;
            paint.setTextSize(l.g(getContext(), R.dimen.T_X08));
            this.k = l.g(getContext(), R.dimen.L_X01);
            onChangeSkinType();
            setOnClickListener(new c(this));
            if (context instanceof g) {
                g gVar = (g) context;
                gVar.getPageContext().registerListener(this.w);
                gVar.getPageContext().registerListener(this.x);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if ((!p(this.q) && !o(this.r) && !n(this.r)) || q(this.q)) {
                this.p = 1;
                this.f47434g = this.n == 0 ? 0 : 100;
            }
            t();
        }
    }

    public void setClickCallback(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.u = eVar;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setCustomColorBtn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.n = i2;
            if (i2 == 0) {
                this.f47436i.setTextSize(l.g(getContext(), R.dimen.T_X08));
            } else {
                this.f47436i.setTextSize(l.g(getContext(), R.dimen.T_X07));
            }
            postInvalidate();
        }
    }

    public void setData(@NonNull Item item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, item) == null) {
            this.q = item;
            if (!ItemCardHelper.t(item)) {
                this.p = 0;
                this.f47434g = this.n == 0 ? 0 : 100;
                this.r = null;
            } else {
                this.r = c.a.o0.d0.a.i(item);
                if ((!p(item) && !o(this.r) && !n(this.r)) || q(item)) {
                    this.p = 1;
                    this.f47434g = this.n == 0 ? 0 : 100;
                }
            }
            t();
            onChangeSkinType();
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.s = str;
            t();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i2 = this.p;
            if (i2 == 0) {
                this.f47433f = TextUtils.isEmpty(this.s) ? this.q.button_name : this.s;
            } else if (i2 == 2) {
                this.f47433f = getResources().getString(R.string.item_download_update);
            } else if (i2 == 3) {
                this.f47433f = getResources().getString(R.string.item_download_install);
            } else if (i2 == 4) {
                this.f47433f = String.format(getResources().getString(R.string.item_download_progress), Integer.valueOf(this.f47434g));
            } else if (i2 != 5) {
                if (i2 != 6) {
                    this.f47433f = this.q.button_name;
                } else {
                    this.f47433f = getResources().getString(R.string.item_download_open);
                }
            } else if (this.n == 0) {
                this.f47433f = getResources().getString(R.string.item_download_pause);
            } else {
                this.f47433f = getResources().getString(R.string.go_on_download);
            }
            postInvalidate();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemCardDownloadButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47435h = 0;
        this.w = new a(this, 2001118);
        this.x = new b(this, 2002504);
        r(context);
    }
}
