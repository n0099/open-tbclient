package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class SupportMenuInflater extends MenuInflater {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    public static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    public static final String LOG_TAG = "SupportMenuInflater";
    public static final int NO_ID = 0;
    public static final String XML_GROUP = "group";
    public static final String XML_ITEM = "item";
    public static final String XML_MENU = "menu";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] mActionProviderConstructorArguments;
    public final Object[] mActionViewConstructorArguments;
    public Context mContext;
    public Object mRealOwner;

    /* loaded from: classes.dex */
    public static class InflatedOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public static final Class<?>[] PARAM_TYPES;
        public transient /* synthetic */ FieldHolder $fh;
        public Method mMethod;
        public Object mRealOwner;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1761116516, "Landroidx/appcompat/view/SupportMenuInflater$InflatedOnMenuItemClickListener;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1761116516, "Landroidx/appcompat/view/SupportMenuInflater$InflatedOnMenuItemClickListener;");
                    return;
                }
            }
            PARAM_TYPES = new Class[]{MenuItem.class};
        }

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mRealOwner = obj;
            Class<?> cls = obj.getClass();
            try {
                this.mMethod = cls.getMethod(str, PARAM_TYPES);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, menuItem)) == null) {
                try {
                    if (this.mMethod.getReturnType() == Boolean.TYPE) {
                        return ((Boolean) this.mMethod.invoke(this.mRealOwner, menuItem)).booleanValue();
                    }
                    this.mMethod.invoke(this.mRealOwner, menuItem);
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class MenuState {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int defaultGroupId = 0;
        public static final int defaultItemCategory = 0;
        public static final int defaultItemCheckable = 0;
        public static final boolean defaultItemChecked = false;
        public static final boolean defaultItemEnabled = true;
        public static final int defaultItemId = 0;
        public static final int defaultItemOrder = 0;
        public static final boolean defaultItemVisible = true;
        public transient /* synthetic */ FieldHolder $fh;
        public int groupCategory;
        public int groupCheckable;
        public boolean groupEnabled;
        public int groupId;
        public int groupOrder;
        public boolean groupVisible;
        public ActionProvider itemActionProvider;
        public String itemActionProviderClassName;
        public String itemActionViewClassName;
        public int itemActionViewLayout;
        public boolean itemAdded;
        public int itemAlphabeticModifiers;
        public char itemAlphabeticShortcut;
        public int itemCategoryOrder;
        public int itemCheckable;
        public boolean itemChecked;
        public CharSequence itemContentDescription;
        public boolean itemEnabled;
        public int itemIconResId;
        public ColorStateList itemIconTintList;
        public PorterDuff.Mode itemIconTintMode;
        public int itemId;
        public String itemListenerMethodName;
        public int itemNumericModifiers;
        public char itemNumericShortcut;
        public int itemShowAsAction;
        public CharSequence itemTitle;
        public CharSequence itemTitleCondensed;
        public CharSequence itemTooltipText;
        public boolean itemVisible;
        public Menu menu;
        public final /* synthetic */ SupportMenuInflater this$0;

        public MenuState(SupportMenuInflater supportMenuInflater, Menu menu) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {supportMenuInflater, menu};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = supportMenuInflater;
            this.itemIconTintList = null;
            this.itemIconTintMode = null;
            this.menu = menu;
            resetGroup();
        }

        private char getShortcut(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
                if (str == null) {
                    return (char) 0;
                }
                return str.charAt(0);
            }
            return invokeL.charValue;
        }

        private <T> T newInstance(String str, Class<?>[] clsArr, Object[] objArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, str, clsArr, objArr)) == null) {
                try {
                    Constructor<?> constructor = Class.forName(str, false, this.this$0.mContext.getClassLoader()).getConstructor(clsArr);
                    constructor.setAccessible(true);
                    return (T) constructor.newInstance(objArr);
                } catch (Exception e) {
                    Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + str, e);
                    return null;
                }
            }
            return (T) invokeLLL.objValue;
        }

        private void setItem(MenuItem menuItem) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, menuItem) == null) {
                MenuItem enabled = menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
                boolean z2 = false;
                if (this.itemCheckable >= 1) {
                    z = true;
                } else {
                    z = false;
                }
                enabled.setCheckable(z).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
                int i = this.itemShowAsAction;
                if (i >= 0) {
                    menuItem.setShowAsAction(i);
                }
                if (this.itemListenerMethodName != null) {
                    if (!this.this$0.mContext.isRestricted()) {
                        menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
                    } else {
                        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                    }
                }
                if (this.itemCheckable >= 2) {
                    if (menuItem instanceof MenuItemImpl) {
                        ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                    } else if (menuItem instanceof MenuItemWrapperICS) {
                        ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                    }
                }
                String str = this.itemActionViewClassName;
                if (str != null) {
                    menuItem.setActionView((View) newInstance(str, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
                    z2 = true;
                }
                int i2 = this.itemActionViewLayout;
                if (i2 > 0) {
                    if (!z2) {
                        menuItem.setActionView(i2);
                    } else {
                        Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                    }
                }
                ActionProvider actionProvider = this.itemActionProvider;
                if (actionProvider != null) {
                    MenuItemCompat.setActionProvider(menuItem, actionProvider);
                }
                MenuItemCompat.setContentDescription(menuItem, this.itemContentDescription);
                MenuItemCompat.setTooltipText(menuItem, this.itemTooltipText);
                MenuItemCompat.setAlphabeticShortcut(menuItem, this.itemAlphabeticShortcut, this.itemAlphabeticModifiers);
                MenuItemCompat.setNumericShortcut(menuItem, this.itemNumericShortcut, this.itemNumericModifiers);
                PorterDuff.Mode mode = this.itemIconTintMode;
                if (mode != null) {
                    MenuItemCompat.setIconTintMode(menuItem, mode);
                }
                ColorStateList colorStateList = this.itemIconTintList;
                if (colorStateList != null) {
                    MenuItemCompat.setIconTintList(menuItem, colorStateList);
                }
            }
        }

        public void addItem() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.itemAdded = true;
                setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
            }
        }

        public SubMenu addSubMenuItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.itemAdded = true;
                SubMenu addSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
                setItem(addSubMenu.getItem());
                return addSubMenu;
            }
            return (SubMenu) invokeV.objValue;
        }

        public boolean hasAddedItem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.itemAdded;
            }
            return invokeV.booleanValue;
        }

        public void resetGroup() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.groupId = 0;
                this.groupCategory = 0;
                this.groupOrder = 0;
                this.groupCheckable = 0;
                this.groupVisible = true;
                this.groupEnabled = true;
            }
        }

        public void readGroup(AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, attributeSet) == null) {
                TypedArray obtainStyledAttributes = this.this$0.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
                this.groupId = obtainStyledAttributes.getResourceId(1, 0);
                this.groupCategory = obtainStyledAttributes.getInt(3, 0);
                this.groupOrder = obtainStyledAttributes.getInt(4, 0);
                this.groupCheckable = obtainStyledAttributes.getInt(5, 0);
                this.groupVisible = obtainStyledAttributes.getBoolean(2, true);
                this.groupEnabled = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }

        public void readItem(AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) {
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.this$0.mContext, attributeSet, R.styleable.MenuItem);
                this.itemId = obtainStyledAttributes.getResourceId(2, 0);
                this.itemCategoryOrder = (obtainStyledAttributes.getInt(5, this.groupCategory) & (-65536)) | (obtainStyledAttributes.getInt(6, this.groupOrder) & 65535);
                this.itemTitle = obtainStyledAttributes.getText(7);
                this.itemTitleCondensed = obtainStyledAttributes.getText(8);
                this.itemIconResId = obtainStyledAttributes.getResourceId(0, 0);
                this.itemAlphabeticShortcut = getShortcut(obtainStyledAttributes.getString(9));
                this.itemAlphabeticModifiers = obtainStyledAttributes.getInt(16, 4096);
                this.itemNumericShortcut = getShortcut(obtainStyledAttributes.getString(10));
                this.itemNumericModifiers = obtainStyledAttributes.getInt(20, 4096);
                if (obtainStyledAttributes.hasValue(11)) {
                    this.itemCheckable = obtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
                } else {
                    this.itemCheckable = this.groupCheckable;
                }
                this.itemChecked = obtainStyledAttributes.getBoolean(3, false);
                this.itemVisible = obtainStyledAttributes.getBoolean(4, this.groupVisible);
                boolean z = true;
                this.itemEnabled = obtainStyledAttributes.getBoolean(1, this.groupEnabled);
                this.itemShowAsAction = obtainStyledAttributes.getInt(21, -1);
                this.itemListenerMethodName = obtainStyledAttributes.getString(12);
                this.itemActionViewLayout = obtainStyledAttributes.getResourceId(13, 0);
                this.itemActionViewClassName = obtainStyledAttributes.getString(15);
                String string = obtainStyledAttributes.getString(14);
                this.itemActionProviderClassName = string;
                if (string == null) {
                    z = false;
                }
                if (z && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
                    this.itemActionProvider = (ActionProvider) newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
                } else {
                    if (z) {
                        Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                    }
                    this.itemActionProvider = null;
                }
                this.itemContentDescription = obtainStyledAttributes.getText(17);
                this.itemTooltipText = obtainStyledAttributes.getText(22);
                if (obtainStyledAttributes.hasValue(19)) {
                    this.itemIconTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(19, -1), this.itemIconTintMode);
                } else {
                    this.itemIconTintMode = null;
                }
                if (obtainStyledAttributes.hasValue(18)) {
                    this.itemIconTintList = obtainStyledAttributes.getColorStateList(18);
                } else {
                    this.itemIconTintList = null;
                }
                obtainStyledAttributes.recycle();
                this.itemAdded = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(358017638, "Landroidx/appcompat/view/SupportMenuInflater;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(358017638, "Landroidx/appcompat/view/SupportMenuInflater;");
                return;
            }
        }
        Class<?>[] clsArr = {Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = clsArr;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = clsArr;
    }

    public Object getRealOwner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mRealOwner == null) {
                this.mRealOwner = findRealOwner(this.mContext);
            }
            return this.mRealOwner;
        }
        return invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportMenuInflater(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        Object[] objArr2 = {context};
        this.mActionViewConstructorArguments = objArr2;
        this.mActionProviderConstructorArguments = objArr2;
    }

    private Object findRealOwner(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, obj)) == null) {
            if (obj instanceof Activity) {
                return obj;
            }
            if (obj instanceof ContextWrapper) {
                return findRealOwner(((ContextWrapper) obj).getBaseContext());
            }
            return obj;
        }
        return invokeL.objValue;
    }

    private void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, xmlPullParser, attributeSet, menu) == null) {
            MenuState menuState = new MenuState(this, menu);
            int eventType = xmlPullParser.getEventType();
            while (true) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (name.equals(XML_MENU)) {
                        eventType = xmlPullParser.next();
                    } else {
                        throw new RuntimeException("Expecting menu, got " + name);
                    }
                } else {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        break;
                    }
                }
            }
            String str = null;
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                if (eventType != 1) {
                    if (eventType != 2) {
                        if (eventType == 3) {
                            String name2 = xmlPullParser.getName();
                            if (z2 && name2.equals(str)) {
                                str = null;
                                z2 = false;
                            } else if (name2.equals("group")) {
                                menuState.resetGroup();
                            } else if (name2.equals("item")) {
                                if (!menuState.hasAddedItem()) {
                                    ActionProvider actionProvider = menuState.itemActionProvider;
                                    if (actionProvider != null && actionProvider.hasSubMenu()) {
                                        menuState.addSubMenuItem();
                                    } else {
                                        menuState.addItem();
                                    }
                                }
                            } else if (name2.equals(XML_MENU)) {
                                z = true;
                            }
                        }
                    } else if (!z2) {
                        String name3 = xmlPullParser.getName();
                        if (name3.equals("group")) {
                            menuState.readGroup(attributeSet);
                        } else if (name3.equals("item")) {
                            menuState.readItem(attributeSet);
                        } else if (name3.equals(XML_MENU)) {
                            parseMenu(xmlPullParser, attributeSet, menuState.addSubMenuItem());
                        } else {
                            str = name3;
                            z2 = true;
                        }
                    }
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Unexpected end of document");
                }
            }
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, menu) == null) {
            if (!(menu instanceof SupportMenu)) {
                super.inflate(i, menu);
                return;
            }
            XmlResourceParser xmlResourceParser = null;
            try {
                try {
                    xmlResourceParser = this.mContext.getResources().getLayout(i);
                    parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } finally {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        }
    }
}
