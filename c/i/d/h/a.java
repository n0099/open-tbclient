package c.i.d.h;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
/* loaded from: classes4.dex */
public class a extends AccessibleObject implements Member {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final AccessibleObject f34306e;

    /* renamed from: f  reason: collision with root package name */
    public final Member f34307f;

    public <M extends AccessibleObject & Member> a(M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(m);
        this.f34306e = m;
        this.f34307f = m;
    }

    public TypeToken<?> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TypeToken.of((Class) getDeclaringClass()) : (TypeToken) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return a().equals(aVar.a()) && this.f34307f.equals(aVar.f34307f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? (A) this.f34306e.getAnnotation(cls) : (A) invokeL.objValue;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34306e.getAnnotations() : (Annotation[]) invokeV.objValue;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34306e.getDeclaredAnnotations() : (Annotation[]) invokeV.objValue;
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34307f.getDeclaringClass() : (Class) invokeV.objValue;
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34307f.getModifiers() : invokeV.intValue;
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34307f.getName() : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34307f.hashCode() : invokeV.intValue;
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34306e.isAccessible() : invokeV.booleanValue;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) ? this.f34306e.isAnnotationPresent(cls) : invokeL.booleanValue;
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34307f.isSynthetic() : invokeV.booleanValue;
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws SecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f34306e.setAccessible(z);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f34307f.toString() : (String) invokeV.objValue;
    }
}
