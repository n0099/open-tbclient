package com.baidu.tbadk.core.view.headViewPendant;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.view.headViewPendant.LightEmotionAdapter;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.ra5;
import com.baidu.tieba.sa5;
import com.baidu.tieba.vi;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
/* loaded from: classes4.dex */
public class LightInteractiveLayout extends ConstraintLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MetaData A;
    public int B;
    public boolean C;
    public RecyclerView.OnItemTouchListener D;
    public List<View> a;
    public BdRecyclerView b;
    public View c;
    public View d;
    public ImageView e;
    public sa5 f;
    public WeakReference<Context> g;
    public LightEmotionAdapter h;
    public ImageView i;
    public RelativeLayout j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public float p;
    public float q;
    public boolean r;
    public AnimatorSet s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public ArrayList<LightEmotionData> z;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ LightInteractiveLayout c;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public a(LightInteractiveLayout lightInteractiveLayout, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightInteractiveLayout, view2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lightInteractiveLayout;
            this.a = view2;
            this.b = i;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setTranslationX(0.0f);
                this.a.setTranslationY(0.0f);
                this.a.setScaleX(1.0f);
                this.a.setScaleY(1.0f);
                this.a.setAlpha(0.0f);
                if (this.c.f != null) {
                    this.c.f.onClose();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.setTranslationX(0.0f);
                this.a.setTranslationY(0.0f);
                this.a.setScaleX(1.0f);
                this.a.setScaleY(1.0f);
                this.a.setAlpha(0.0f);
                if (this.c.A != null) {
                    this.c.M(this.b);
                }
                if (this.c.f != null) {
                    this.c.f.onClose();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RecyclerView.OnItemTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LightInteractiveLayout a;

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, recyclerView, motionEvent) == null) {
            }
        }

        public b(LightInteractiveLayout lightInteractiveLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightInteractiveLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lightInteractiveLayout;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, recyclerView, motionEvent)) == null) {
                if (motionEvent.getAction() != 0) {
                    if (!this.a.C || motionEvent.getAction() != 2) {
                        if (this.a.C && motionEvent.getAction() == 1) {
                            this.a.v = (int) motionEvent.getRawX();
                            this.a.w = (int) motionEvent.getRawY();
                            LightInteractiveLayout lightInteractiveLayout = this.a;
                            lightInteractiveLayout.P(lightInteractiveLayout.d, this.a.o);
                            if (!this.a.r || this.a.o + 1 != this.a.b.getChildCount()) {
                                LightInteractiveLayout lightInteractiveLayout2 = this.a;
                                lightInteractiveLayout2.N(lightInteractiveLayout2.d, this.a.o);
                            } else {
                                this.a.H();
                            }
                            if (this.a.c != null) {
                                this.a.b.requestLayout();
                                this.a.c = null;
                            }
                        }
                    } else {
                        this.a.v = (int) motionEvent.getRawX();
                        this.a.w = (int) motionEvent.getRawY();
                        boolean z = false;
                        int i = 0;
                        for (View view2 : this.a.a) {
                            LightInteractiveLayout lightInteractiveLayout3 = this.a;
                            if (lightInteractiveLayout3.G(view2, lightInteractiveLayout3.v, this.a.w) && this.a.d != view2) {
                                this.a.d = view2;
                                this.a.o = i;
                                z = true;
                            }
                            i++;
                        }
                        if (z) {
                            this.a.d.setTranslationX(0.0f);
                            int i2 = 0;
                            for (View view3 : this.a.a) {
                                if (i2 >= this.a.o) {
                                    if (i2 != this.a.o) {
                                        if (i2 < this.a.a.size()) {
                                            this.a.J(view3, i2);
                                        }
                                    } else {
                                        this.a.O(view3, i2);
                                    }
                                } else {
                                    this.a.I(view3, i2);
                                }
                                i2++;
                            }
                        }
                    }
                } else {
                    this.a.v = (int) motionEvent.getRawX();
                    this.a.w = (int) motionEvent.getRawY();
                    int i3 = 0;
                    for (View view4 : this.a.a) {
                        LightInteractiveLayout lightInteractiveLayout4 = this.a;
                        if (lightInteractiveLayout4.G(view4, lightInteractiveLayout4.v, this.a.w) && this.a.d != view4) {
                            this.a.d = view4;
                            this.a.o = i3;
                            this.a.C = true;
                        }
                        i3++;
                    }
                    if (this.a.C) {
                        int i4 = 0;
                        boolean z2 = false;
                        for (View view5 : this.a.a) {
                            LightInteractiveLayout lightInteractiveLayout5 = this.a;
                            if (lightInteractiveLayout5.G(view5, lightInteractiveLayout5.v, this.a.w)) {
                                this.a.O(view5, i4);
                                this.a.o = i4;
                                this.a.d = view5;
                                z2 = true;
                            }
                            if (!z2) {
                                this.a.I(view5, i4);
                            }
                            if (z2 && i4 > this.a.o) {
                                this.a.J(view5, i4);
                            }
                            i4++;
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LightInteractiveLayout a;

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LightInteractiveLayout lightInteractiveLayout, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lightInteractiveLayout, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lightInteractiveLayout;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightInteractiveLayout(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.c = null;
        this.d = null;
        this.o = 10;
        this.C = false;
        this.D = new b(this);
        F(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightInteractiveLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.c = null;
        this.d = null;
        this.o = 10;
        this.C = false;
        this.D = new b(this);
        F(context);
    }

    public final void O(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) && view2 != null && i < this.B) {
            view2.setPivotY(view2.getHeight());
            view2.setPivotX((view2.getWidth() / this.B) * i);
            ViewPropertyAnimator animate = view2.animate();
            animate.scaleX(2.0f);
            animate.scaleY(2.0f);
            animate.start();
            BdRecyclerView bdRecyclerView = this.b;
            if (bdRecyclerView != null && i < bdRecyclerView.getChildCount() && (this.b.findViewHolderForAdapterPosition(i) instanceof LightEmotionAdapter.LightEmotionView)) {
                ((LightEmotionAdapter.LightEmotionView) Objects.requireNonNull(this.b.findViewHolderForAdapterPosition(i))).b.setVisibility(0);
            }
        }
    }

    public final void P(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048586, this, view2, i) != null) || view2 == null) {
            return;
        }
        BdRecyclerView bdRecyclerView = this.b;
        if (bdRecyclerView != null && i < bdRecyclerView.getChildCount() && (this.b.findViewHolderForAdapterPosition(i) instanceof LightEmotionAdapter.LightEmotionView)) {
            ((LightEmotionAdapter.LightEmotionView) Objects.requireNonNull(this.b.findViewHolderForAdapterPosition(i))).b.setVisibility(8);
        }
        view2.setPivotY(view2.getHeight());
        view2.setPivotX(0.0f);
        ViewPropertyAnimator animate = view2.animate();
        animate.scaleX(1.0f);
        animate.scaleY(1.0f);
        animate.start();
    }

    public void setListBackground(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) && this.e != null && getViewContext() != null) {
            int l = wi.l(getViewContext()) / 2;
            int j = wi.j(getViewContext()) / 3;
            if (i < l && i2 < j) {
                SkinManager.setImageResource(this.e, R.drawable.icon_qinghudong_left_up);
            } else if (i < l && i2 > j) {
                SkinManager.setImageResource(this.e, R.drawable.icon_qinghudong_left_below);
            } else if (i > l && i2 < j) {
                SkinManager.setImageResource(this.e, R.drawable.icon_qinghudong_right_up);
            } else if (i > l && i2 > j) {
                SkinManager.setImageResource(this.e, R.drawable.icon_qinghudong_right_below);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightInteractiveLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = new ArrayList();
        this.c = null;
        this.d = null;
        this.o = 10;
        this.C = false;
        this.D = new b(this);
        F(context);
    }

    public void setFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.y = i;
        }
    }

    public void setNeedHomeIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.r = z;
        }
    }

    public void setOnDismissListener(sa5 sa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, sa5Var) == null) {
            this.f = sa5Var;
            LightEmotionAdapter lightEmotionAdapter = this.h;
            if (lightEmotionAdapter != null) {
                lightEmotionAdapter.p(sa5Var);
            }
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.x = i;
        }
    }

    public void setUserInfo(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, metaData) == null) {
            this.A = metaData;
        }
    }

    public final boolean G(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, view2, i, i2)) == null) {
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            int measuredWidth = view2.getMeasuredWidth() + i3;
            int measuredHeight = view2.getMeasuredHeight() + i4;
            if (i2 <= i4 || i2 > measuredHeight || i <= i3 || i > measuredWidth) {
                return false;
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    private Context getViewContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            WeakReference<Context> weakReference = this.g;
            if (weakReference != null) {
                return weakReference.get();
            }
            sa5 sa5Var = this.f;
            if (sa5Var != null) {
                sa5Var.onClose();
                return null;
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public void E() {
        AnimatorSet animatorSet;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (animatorSet = this.s) != null) {
            animatorSet.cancel();
        }
    }

    public MetaData getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.A;
        }
        return (MetaData) invokeV.objValue;
    }

    public final void F(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.g = new WeakReference<>(context);
            this.h = new LightEmotionAdapter(getViewContext());
            LayoutInflater.from(getViewContext()).inflate(R.layout.light_inter_layout, (ViewGroup) this, true);
            this.b = (BdRecyclerView) findViewById(R.id.light_list_view);
            this.e = (ImageView) findViewById(R.id.list_view_bobble);
            this.i = new TbImageView(getViewContext());
            UtilHelper.getDimenPixelSize(R.dimen.tbds104);
            UtilHelper.getDimenPixelSize(R.dimen.tbds208);
            UtilHelper.getDimenPixelSize(R.dimen.tbds100);
            UtilHelper.getDimenPixelSize(R.dimen.tbds85);
            UtilHelper.getDimenPixelSize(R.dimen.tbds250);
            UtilHelper.getDimenPixelSize(R.dimen.tbds432);
            new Matrix();
            this.j = new RelativeLayout(getViewContext());
            this.j.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            SkinManager.setImageResource(this.i, R.drawable.icon_pic_qinghudong_home_normal);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds104), UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds23);
            layoutParams.gravity = 81;
            this.i.setLayoutParams(layoutParams);
            this.j.addView(this.i);
            this.b.addOnItemTouchListener(this.D);
            this.s = new AnimatorSet();
            setClipChildren(false);
        }
    }

    public final void M(int i) {
        ArrayList<LightEmotionData> arrayList;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (arrayList = this.z) != null && i + 1 <= arrayList.size()) {
            new LightEmotionData();
            LightEmotionData lightEmotionData = this.z.get(i);
            String valueOf = String.valueOf(TbadkCoreApplication.getCurrentAccountId());
            MetaData metaData = this.A;
            if (metaData != null && vi.isEquals(metaData.getUserId(), valueOf)) {
                return;
            }
            int i2 = this.x;
            if (i2 == 1) {
                K(lightEmotionData.getId());
                MetaData metaData2 = this.A;
                if (metaData2 != null) {
                    ra5.a(this.y, metaData2.getUserId(), lightEmotionData.getId());
                }
            } else if (i2 == 3) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", lightEmotionData.getId());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uniqueKey", "kTBCVirtualInteractivePopupViewClick");
                hashMap2.put("data", hashMap);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921542, hashMap2));
            }
            MetaData metaData3 = this.A;
            if (metaData3 != null && metaData3.getUserId() != null && !this.A.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                String id = lightEmotionData.getId();
                String url = lightEmotionData.getUrl();
                long userIdLong = this.A.getUserIdLong();
                String userName = this.A.getUserName();
                String name_show = this.A.getName_show();
                String portrait = this.A.getPortrait();
                if (this.A.getIsMyFriend() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                MessageUtils.createAndSendPersonalReactionsPicChatMessage(id, url, 0, 0, userIdLong, userName, name_show, portrait, z);
            }
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.A != null && getViewContext() != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getViewContext(), this.A.getUserId(), this.A.getUserName())));
            sa5 sa5Var = this.f;
            if (sa5Var != null) {
                sa5Var.onClose();
            }
        }
    }

    public void setImageData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ArrayList<LightEmotionData> arrayList = new ArrayList<>();
            this.z = arrayList;
            arrayList.clear();
            this.z.addAll(TbSingleton.getInstance().getLightEmotionInfo());
            LightEmotionAdapter lightEmotionAdapter = this.h;
            if (lightEmotionAdapter != null) {
                lightEmotionAdapter.m(this.z);
                this.h.notifyDataSetChanged();
            }
        }
    }

    public final void I(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) && view2 != null && i < this.B) {
            BdRecyclerView bdRecyclerView = this.b;
            if (bdRecyclerView != null && i < bdRecyclerView.getChildCount() && (this.b.findViewHolderForAdapterPosition(i) instanceof LightEmotionAdapter.LightEmotionView)) {
                ((LightEmotionAdapter.LightEmotionView) Objects.requireNonNull(this.b.findViewHolderForAdapterPosition(i))).b.setVisibility(8);
            }
            view2.setPivotY(view2.getHeight());
            view2.setPivotX(view2.getWidth() / 2);
            ViewPropertyAnimator animate = view2.animate();
            animate.scaleX(0.9f);
            animate.scaleY(0.9f);
            animate.translationX((-17.0f) * (i + 1));
            animate.start();
        }
    }

    public final void J(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, view2, i) == null) && view2 != null && i < this.B) {
            BdRecyclerView bdRecyclerView = this.b;
            if (bdRecyclerView != null && i < bdRecyclerView.getChildCount() && (this.b.findViewHolderForAdapterPosition(i) instanceof LightEmotionAdapter.LightEmotionView)) {
                ((LightEmotionAdapter.LightEmotionView) Objects.requireNonNull(this.b.findViewHolderForAdapterPosition(i))).b.setVisibility(8);
            }
            view2.setPivotY(view2.getHeight());
            view2.setPivotX(view2.getWidth() / 2);
            ViewPropertyAnimator animate = view2.animate();
            animate.scaleX(0.9f);
            animate.scaleY(0.9f);
            animate.translationX((this.a.size() - i) * 17.0f);
            animate.start();
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && str != null && this.A != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_QINGHUDONG_EMOTION);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.addParam("agreed_user_id", this.A.getUserId());
            httpMessage.addParam("interactive_id", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0) {
                this.v = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                this.w = rawY;
                if (!G(this.b, this.v, rawY)) {
                    sa5 sa5Var = this.f;
                    if (sa5Var != null) {
                        sa5Var.onClose();
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void N(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) != null) || view2 == null) {
            return;
        }
        Path path = new Path();
        float x = view2.getX();
        float y = view2.getY();
        path.moveTo(x, y);
        path.quadTo(x, y - 500.0f, this.p, this.q);
        PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.12f, 1.0f);
        this.s.addListener(new a(this, view2, i));
        this.s.playTogether(ObjectAnimator.ofFloat(view2, View.SCALE_X, 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, View.SCALE_Y, 1.0f, 0.0f), ObjectAnimator.ofFloat(view2, "x", "y", path));
        this.s.setInterpolator(pathInterpolator);
        this.s.setDuration(600L);
        this.s.start();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            List<View> list = this.a;
            if (list != null && list.size() == 0 && this.b != null) {
                for (int i5 = 0; i5 < this.b.getChildCount(); i5++) {
                    if (this.b.getChildAt(i5) != null) {
                        this.a.add(this.b.getChildAt(i5));
                    }
                }
                this.B = this.b.getChildCount();
            }
        }
    }

    public void setLocation(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048593, this, i, i2) != null) || getViewContext() == null) {
            return;
        }
        int l = wi.l(getViewContext()) / 2;
        int j = wi.j(getViewContext()) / 3;
        this.t = i;
        this.u = i2;
        c cVar = new c(this, getViewContext());
        cVar.setOrientation(0);
        BdRecyclerView bdRecyclerView = this.b;
        if (bdRecyclerView != null && this.e != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) bdRecyclerView.getLayoutParams();
            if (this.x == 3) {
                this.k = i - UtilHelper.getDimenPixelSize(R.dimen.tbds550);
                this.l = i2 + UtilHelper.getDimenPixelSize(R.dimen.tbds70);
                ViewCommonUtil.setViewPadding(this.b, -1, -1, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds10));
                this.p = 700.0f;
                this.q = -200.0f;
                cVar.setStackFromEnd(false);
                cVar.setReverseLayout(false);
            } else if (i < l && i2 < j) {
                ViewCommonUtil.setViewPadding(this.b, -1, -1, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds10));
                if (this.r) {
                    ViewCommonUtil.setViewMargin(this.i, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds38), -1, -1);
                }
                this.k = i - UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                this.l = i2;
                this.p = 100.0f;
                this.q = -200.0f;
            } else if (i < l && i2 > j) {
                this.k = i - UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                this.l = i2 - UtilHelper.getDimenPixelSize(R.dimen.tbds280);
                this.p = 100.0f;
                this.q = 100.0f;
            } else if (i > l && i2 < j) {
                ViewCommonUtil.setViewPadding(this.b, -1, -1, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds10));
                this.k = i - UtilHelper.getDimenPixelSize(R.dimen.tbds626);
                this.l = i2 + UtilHelper.getDimenPixelSize(R.dimen.tbds10);
                this.p = 740.0f;
                this.q = -200.0f;
                cVar.setStackFromEnd(false);
                cVar.setReverseLayout(false);
            } else if (i > l && i2 > j) {
                this.k = i - UtilHelper.getDimenPixelSize(R.dimen.tbds626);
                this.l = i2 - UtilHelper.getDimenPixelSize(R.dimen.tbds300);
                this.p = 740.0f;
                this.q = 100.0f;
                cVar.setStackFromEnd(false);
                cVar.setReverseLayout(false);
            }
            setListBackground(this.t, this.u);
            layoutParams.setMargins(this.k, this.l, this.m, this.n);
            this.b.setLayoutManager(cVar);
            this.b.setAdapter(this.h);
            if (this.r) {
                this.b.addFooterView(this.j);
            }
            setImageData();
        }
    }
}
