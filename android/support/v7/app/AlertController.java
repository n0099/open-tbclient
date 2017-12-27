package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.appcompat.R;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class AlertController {
    final AppCompatDialog BG;
    private final Window BH;
    Button BI;
    private CharSequence BJ;
    Message BK;
    Button BL;
    private CharSequence BM;
    Message BN;
    Button BO;
    private CharSequence BP;
    Message BQ;
    NestedScrollView BR;
    private int BS;
    private int BT;
    int BU;
    int BV;
    int BW;
    int BX;
    ListAdapter mAdapter;
    private final Context mContext;
    private View mCustomTitleView;
    Handler mHandler;
    private Drawable mIcon;
    private ImageView mIconView;
    ListView mListView;
    private CharSequence mMessage;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private int mViewSpacingTop;
    private TextView pV;
    private boolean mViewSpacingSpecified = false;
    private int mIconId = 0;
    int mCheckedItem = -1;
    private int BY = 0;
    private final View.OnClickListener BZ = new View.OnClickListener() { // from class: android.support.v7.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            if (view == AlertController.this.BI && AlertController.this.BK != null) {
                message = Message.obtain(AlertController.this.BK);
            } else if (view == AlertController.this.BL && AlertController.this.BN != null) {
                message = Message.obtain(AlertController.this.BN);
            } else if (view == AlertController.this.BO && AlertController.this.BQ != null) {
                message = Message.obtain(AlertController.this.BQ);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.mHandler.obtainMessage(1, AlertController.this.BG).sendToTarget();
        }
    };

    /* loaded from: classes2.dex */
    private static final class a extends Handler {
        private WeakReference<DialogInterface> Ci;

        public a(DialogInterface dialogInterface) {
            this.Ci = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.Ci.get(), message.what);
                    return;
                case 0:
                default:
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.BG = appCompatDialog;
        this.BH = window;
        this.mHandler = new a(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.BS = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.BT = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.BU = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.BV = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.BW = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.BX = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean S(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (S(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void dR() {
        this.BG.setContentView(dS());
        dT();
    }

    private int dS() {
        if (this.BT == 0) {
            return this.BS;
        }
        if (this.BY == 1) {
            return this.BT;
        }
        return this.BS;
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        if (this.mTitleView != null) {
            this.mTitleView.setText(charSequence);
        }
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        if (this.pV != null) {
            this.pV.setText(charSequence);
        }
    }

    public void av(int i) {
        this.mView = null;
        this.mViewLayoutResId = i;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i3;
        this.mViewSpacingBottom = i4;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.BP = charSequence;
                this.BQ = message;
                return;
            case -2:
                this.BM = charSequence;
                this.BN = message;
                return;
            case -1:
                this.BJ = charSequence;
                this.BK = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setIcon(int i) {
        this.mIcon = null;
        this.mIconId = i;
        if (this.mIconView != null) {
            if (i != 0) {
                this.mIconView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
                return;
            }
            this.mIconView.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        if (this.mIconView != null) {
            if (drawable != null) {
                this.mIconView.setVisibility(0);
                this.mIconView.setImageDrawable(drawable);
                return;
            }
            this.mIconView.setVisibility(8);
        }
    }

    public int aw(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public Button getButton(int i) {
        switch (i) {
            case -3:
                return this.BO;
            case -2:
                return this.BL;
            case -1:
                return this.BI;
            default:
                return null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.BR != null && this.BR.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.BR != null && this.BR.executeKeyEvent(keyEvent);
    }

    private ViewGroup c(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void dT() {
        View findViewById;
        View findViewById2 = this.BH.findViewById(R.id.parentPanel);
        View findViewById3 = findViewById2.findViewById(R.id.topPanel);
        View findViewById4 = findViewById2.findViewById(R.id.contentPanel);
        View findViewById5 = findViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        d(viewGroup);
        View findViewById6 = viewGroup.findViewById(R.id.topPanel);
        View findViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup c = c(findViewById6, findViewById3);
        ViewGroup c2 = c(findViewById7, findViewById4);
        ViewGroup c3 = c(findViewById8, findViewById5);
        f(c2);
        g(c3);
        e(c);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (c == null || c.getVisibility() == 8) ? false : true;
        boolean z3 = (c3 == null || c3.getVisibility() == 8) ? false : true;
        if (!z3 && c2 != null && (findViewById = c2.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (z2 && this.BR != null) {
            this.BR.setClipToPadding(true);
        }
        if (!z) {
            ListView listView = this.mListView != null ? this.mListView : this.BR;
            if (listView != null) {
                a(c2, listView, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView2 = this.mListView;
        if (listView2 != null && this.mAdapter != null) {
            listView2.setAdapter(this.mAdapter);
            int i = this.mCheckedItem;
            if (i > -1) {
                listView2.setItemChecked(i, true);
                listView2.setSelection(i);
            }
        }
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        final View view2 = null;
        final View findViewById = this.BH.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.BH.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.mMessage != null) {
                this.BR.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: android.support.v7.app.AlertController.2
                    @Override // android.support.v4.widget.NestedScrollView.OnScrollChangeListener
                    public void onScrollChange(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                        AlertController.a(nestedScrollView, findViewById, view2);
                    }
                });
                this.BR.post(new Runnable() { // from class: android.support.v7.app.AlertController.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.a(AlertController.this.BR, findViewById, view2);
                    }
                });
            } else if (this.mListView != null) {
                this.mListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.app.AlertController.4
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i3) {
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                        AlertController.a(absListView, findViewById, view2);
                    }
                });
                this.mListView.post(new Runnable() { // from class: android.support.v7.app.AlertController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.a(AlertController.this.mListView, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    private void d(ViewGroup viewGroup) {
        View view;
        if (this.mView != null) {
            view = this.mView;
        } else if (this.mViewLayoutResId != 0) {
            view = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false);
        } else {
            view = null;
        }
        boolean z = view != null;
        if (!z || !S(view)) {
            this.BH.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.BH.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void e(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.BH.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.BH.findViewById(16908294);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.mTitleView = (TextView) this.BH.findViewById(R.id.alertTitle);
            this.mTitleView.setText(this.mTitle);
            if (this.mIconId != 0) {
                this.mIconView.setImageResource(this.mIconId);
                return;
            } else if (this.mIcon != null) {
                this.mIconView.setImageDrawable(this.mIcon);
                return;
            } else {
                this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                this.mIconView.setVisibility(8);
                return;
            }
        }
        this.BH.findViewById(R.id.title_template).setVisibility(8);
        this.mIconView.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void f(ViewGroup viewGroup) {
        this.BR = (NestedScrollView) this.BH.findViewById(R.id.scrollView);
        this.BR.setFocusable(false);
        this.BR.setNestedScrollingEnabled(false);
        this.pV = (TextView) viewGroup.findViewById(16908299);
        if (this.pV != null) {
            if (this.mMessage != null) {
                this.pV.setText(this.mMessage);
                return;
            }
            this.pV.setVisibility(8);
            this.BR.removeView(this.pV);
            if (this.mListView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.BR.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.BR);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(ViewCompat.canScrollVertically(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(ViewCompat.canScrollVertically(view, 1) ? 0 : 4);
        }
    }

    private void g(ViewGroup viewGroup) {
        boolean z;
        this.BI = (Button) viewGroup.findViewById(16908313);
        this.BI.setOnClickListener(this.BZ);
        if (TextUtils.isEmpty(this.BJ)) {
            this.BI.setVisibility(8);
            z = false;
        } else {
            this.BI.setText(this.BJ);
            this.BI.setVisibility(0);
            z = true;
        }
        this.BL = (Button) viewGroup.findViewById(16908314);
        this.BL.setOnClickListener(this.BZ);
        if (TextUtils.isEmpty(this.BM)) {
            this.BL.setVisibility(8);
        } else {
            this.BL.setText(this.BM);
            this.BL.setVisibility(0);
            z |= true;
        }
        this.BO = (Button) viewGroup.findViewById(16908315);
        this.BO.setOnClickListener(this.BZ);
        if (TextUtils.isEmpty(this.BP)) {
            this.BO.setVisibility(8);
        } else {
            this.BO.setText(this.BP);
            this.BO.setVisibility(0);
            z |= true;
        }
        if (!(z)) {
            viewGroup.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean mCancelable = true;

        /* loaded from: classes2.dex */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void apply(AlertController alertController) {
            if (this.mCustomTitleView != null) {
                alertController.setCustomTitle(this.mCustomTitleView);
            } else {
                if (this.mTitle != null) {
                    alertController.setTitle(this.mTitle);
                }
                if (this.mIcon != null) {
                    alertController.setIcon(this.mIcon);
                }
                if (this.mIconId != 0) {
                    alertController.setIcon(this.mIconId);
                }
                if (this.mIconAttrId != 0) {
                    alertController.setIcon(alertController.aw(this.mIconAttrId));
                }
            }
            if (this.mMessage != null) {
                alertController.setMessage(this.mMessage);
            }
            if (this.mPositiveButtonText != null) {
                alertController.a(-1, this.mPositiveButtonText, this.mPositiveButtonListener, (Message) null);
            }
            if (this.mNegativeButtonText != null) {
                alertController.a(-2, this.mNegativeButtonText, this.mNegativeButtonListener, (Message) null);
            }
            if (this.mNeutralButtonText != null) {
                alertController.a(-3, this.mNeutralButtonText, this.mNeutralButtonListener, (Message) null);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                a(alertController);
            }
            if (this.mView != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(this.mView, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                } else {
                    alertController.setView(this.mView);
                }
            } else if (this.mViewLayoutResId != 0) {
                alertController.av(this.mViewLayoutResId);
            }
        }

        private void a(final AlertController alertController) {
            int i;
            ListAdapter bVar;
            final ListView listView = (ListView) this.mInflater.inflate(alertController.BU, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                if (this.mCursor == null) {
                    bVar = new ArrayAdapter<CharSequence>(this.mContext, alertController.BV, 16908308, this.mItems) { // from class: android.support.v7.app.AlertController.AlertParams.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i2, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i2, view, viewGroup);
                            if (AlertParams.this.mCheckedItems != null && AlertParams.this.mCheckedItems[i2]) {
                                listView.setItemChecked(i2, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    bVar = new CursorAdapter(this.mContext, this.mCursor, false) { // from class: android.support.v7.app.AlertController.AlertParams.2
                        private final int Cf;
                        private final int Cg;

                        {
                            Cursor cursor = getCursor();
                            this.Cf = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                            this.Cg = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.Cf));
                            listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.Cg) == 1);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return AlertParams.this.mInflater.inflate(alertController.BV, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.mIsSingleChoice) {
                    i = alertController.BW;
                } else {
                    i = alertController.BX;
                }
                if (this.mCursor != null) {
                    bVar = new SimpleCursorAdapter(this.mContext, i, this.mCursor, new String[]{this.mLabelColumn}, new int[]{16908308});
                } else if (this.mAdapter != null) {
                    bVar = this.mAdapter;
                } else {
                    bVar = new b(this.mContext, i, 16908308, this.mItems);
                }
            }
            if (this.mOnPrepareListViewListener != null) {
                this.mOnPrepareListViewListener.onPrepareListView(listView);
            }
            alertController.mAdapter = bVar;
            alertController.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        AlertParams.this.mOnClickListener.onClick(alertController.BG, i2);
                        if (!AlertParams.this.mIsSingleChoice) {
                            alertController.BG.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                        if (AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[i2] = listView.isItemChecked(i2);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.BG, i2, listView.isItemChecked(i2));
                    }
                });
            }
            if (this.mOnItemSelectedListener != null) {
                listView.setOnItemSelectedListener(this.mOnItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                listView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                listView.setChoiceMode(2);
            }
            alertController.mListView = listView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends ArrayAdapter<CharSequence> {
        public b(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }
    }
}
