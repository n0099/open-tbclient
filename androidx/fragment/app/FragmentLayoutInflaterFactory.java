package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FragmentManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view2, String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, view2, str, context, attributeSet)) == null) {
            if (FragmentContainerView.class.getName().equals(str)) {
                return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
            }
            Fragment fragment = null;
            if (!"fragment".equals(str)) {
                return null;
            }
            String attributeValue = attributeSet.getAttributeValue(null, DealIntentService.KEY_CLASS);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
            int i2 = 0;
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
                return null;
            }
            if (view2 != null) {
                i2 = view2.getId();
            }
            if (i2 == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            if (resourceId != -1) {
                fragment = this.mFragmentManager.findFragmentById(resourceId);
            }
            if (fragment == null && string != null) {
                fragment = this.mFragmentManager.findFragmentByTag(string);
            }
            if (fragment == null && i2 != -1) {
                fragment = this.mFragmentManager.findFragmentById(i2);
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragment);
            }
            if (fragment == null) {
                fragment = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                fragment.mFromLayout = true;
                if (resourceId != 0) {
                    i = resourceId;
                } else {
                    i = i2;
                }
                fragment.mFragmentId = i;
                fragment.mContainerId = i2;
                fragment.mTag = string;
                fragment.mInLayout = true;
                FragmentManager fragmentManager = this.mFragmentManager;
                fragment.mFragmentManager = fragmentManager;
                FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
                fragment.mHost = fragmentHostCallback;
                fragment.onInflate(fragmentHostCallback.getContext(), attributeSet, fragment.mSavedFragmentState);
                this.mFragmentManager.addFragment(fragment);
                this.mFragmentManager.moveToState(fragment);
            } else if (!fragment.mInLayout) {
                fragment.mInLayout = true;
                FragmentHostCallback<?> fragmentHostCallback2 = this.mFragmentManager.mHost;
                fragment.mHost = fragmentHostCallback2;
                fragment.onInflate(fragmentHostCallback2.getContext(), attributeSet, fragment.mSavedFragmentState);
            } else {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + attributeValue);
            }
            FragmentManager fragmentManager2 = this.mFragmentManager;
            if (fragmentManager2.mCurState < 1 && fragment.mFromLayout) {
                fragmentManager2.moveToState(fragment, 1);
            } else {
                this.mFragmentManager.moveToState(fragment);
            }
            View view3 = fragment.mView;
            if (view3 != null) {
                if (resourceId != 0) {
                    view3.setId(resourceId);
                }
                if (fragment.mView.getTag() == null) {
                    fragment.mView.setTag(string);
                }
                return fragment.mView;
            }
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        return (View) invokeLLLL.objValue;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, context, attributeSet)) == null) {
            return onCreateView(null, str, context, attributeSet);
        }
        return (View) invokeLLL.objValue;
    }
}
