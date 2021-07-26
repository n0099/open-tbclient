package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.s;
/* loaded from: classes2.dex */
public class ThreadCardView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public s f4611e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f4612f;

    /* renamed from: g  reason: collision with root package name */
    public int f4613g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4614h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4615i;
    public Runnable j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCardView f4616e;

        public a(ThreadCardView threadCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4616e = threadCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4616e.f4614h) {
                return;
            }
            if (this.f4616e.f4611e != null) {
                CardLinkageManager.INSTANCE.pressLinkage(this.f4616e.f4611e, this.f4616e.f4613g, true);
            } else if (this.f4616e.f4612f instanceof s) {
                CardLinkageManager.INSTANCE.pressLinkage((s) this.f4616e.f4612f, this.f4616e.f4613g, true);
            }
            if (this.f4616e.f4614h) {
                CardLinkageManager.INSTANCE.pressLinkage((s) this.f4616e.f4612f, this.f4616e.f4613g, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadCardView f4617e;

        public b(ThreadCardView threadCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4617e = threadCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4617e.f4611e != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(this.f4617e.f4611e, this.f4617e.f4613g, false);
                } else if (this.f4617e.f4612f instanceof s) {
                    CardLinkageManager.INSTANCE.pressLinkage((s) this.f4617e.f4612f, this.f4617e.f4613g, false);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4615i = new a(this);
        this.j = new b(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeCallbacks(this.f4615i);
            removeCallbacks(this.j);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4614h = false;
                postDelayed(this.f4615i, ViewConfiguration.getTapTimeout());
            } else if (action == 1) {
                this.f4614h = true;
                removeCallbacks(this.f4615i);
                CardLinkageManager.INSTANCE.pressLinkage(this.f4611e, this.f4613g, true);
                postDelayed(this.j, ViewConfiguration.getTapTimeout());
            } else if (action == 3) {
                this.f4614h = true;
                removeCallbacks(this.f4615i);
                removeCallbacks(this.j);
                s sVar = this.f4611e;
                if (sVar != null) {
                    CardLinkageManager.INSTANCE.pressLinkage(sVar, this.f4613g, false);
                } else {
                    ViewGroup viewGroup = this.f4612f;
                    if (viewGroup instanceof s) {
                        CardLinkageManager.INSTANCE.pressLinkage((s) viewGroup, this.f4613g, false);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setITypeListView(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sVar) == null) {
            this.f4611e = sVar;
        }
    }

    public void setParent(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.f4612f = viewGroup;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f4613g = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4615i = new a(this);
        this.j = new b(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f4615i = new a(this);
        this.j = new b(this);
    }
}
