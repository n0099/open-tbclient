package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private View OJ;
    private View OL;
    private RadioButton OT;
    private RadioButton OV;
    private LinearLayout Pf;
    private HashMap<String, Bitmap> Ph;
    private HashMap<String, ImageView> Pi;
    private View Pj;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String OD = "resourceid";
    public static String OE = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String OF = "change";
    public static String FILE_NAME = "file_name";
    private static String[] OG = null;
    private EditHeadsImageView OH = null;
    private Bitmap mBitmap = null;
    private int OI = 0;
    private Button OM = null;
    private Button OO = null;
    private HorizontalScrollView OP = null;
    private ProgressBar mProgress = null;
    private m OQ = null;
    private j OR = null;
    private LinearLayout OW = null;
    private LinearLayout OX = null;
    private o OY = null;
    private TextView mTitle = null;
    private Bitmap OZ = null;
    private n Pa = null;
    private int Pb = 0;
    private int Pc = 0;
    private boolean Pd = true;
    private String Pe = null;
    private boolean Pg = false;
    private final Handler mHandler = new Handler();

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(EditHeadActivityConfig.class, EditHeadActivity.class);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData, int i3) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra("request", i);
        intent.putExtra(EditHeadActivityConfig.ACCOUNTDATA, accountData);
        intent.putExtra("edit_type", i3);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.dc().Z("motu_sdk") == 1 || PluginPackageManager.ic().bm("com.baidu.tieba.pluginMotu") == PluginPackageManager.PluginStatus.DISABLE) {
            this.Pd = false;
        } else {
            this.Pd = true;
        }
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.edit_head_activity);
        Intent intent = getIntent();
        this.OI = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), bb.px().pD());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, bb.px().pD(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        OG = getResources().getStringArray(com.baidu.tieba.r.fiter_name);
        if (this.Pd) {
            TbadkCoreApplication.m255getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ax.j(this.mNavigationBar, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.OJ);
        getLayoutMode().h(this.mTitle);
        getLayoutMode().h(this.OL);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.OQ != null) {
            this.OQ.cancel();
        }
        this.OH.setImageDrawable(null);
        qY();
    }

    private void qY() {
        if (this.Pi != null) {
            for (Map.Entry<String, ImageView> entry : this.Pi.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.Pi.clear();
            this.Pi = null;
        }
        if (this.Ph != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.Ph.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.Ph.clear();
            this.Ph = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.OQ != null) {
            this.OQ.cancel();
        }
        this.OQ = new m(this, null);
        this.OQ.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra(EditHeadActivityConfig.ACCOUNTDATA);
        if (accountData != null) {
            TbadkCoreApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getBaseContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.OH.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.OY != null) {
            this.OY.cancel();
        }
        if (this.OZ != null && !this.OZ.isRecycled()) {
            this.OZ.recycle();
            this.OZ = null;
        }
        if (this.OQ != null) {
            this.OQ.cancel();
            this.OQ = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.Pa);
        }
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qZ() {
        if (this.OY != null) {
            this.OY.cancel();
        }
        this.OY = new o(this, null);
        this.OY.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.mProgress.setVisibility(8);
        this.OH = (EditHeadsImageView) findViewById(com.baidu.tieba.w.image);
        if (this.mBitmap != null) {
            this.OH.setImageBitmap(this.mBitmap);
        }
        this.OP = (HorizontalScrollView) findViewById(com.baidu.tieba.w.filters_layout);
        this.OJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.OO = (Button) findViewById(com.baidu.tieba.w.show_button);
        this.OO.setOnClickListener(new b(this));
        this.OM = (Button) findViewById(com.baidu.tieba.w.hide_button);
        this.OM.setVisibility(0);
        this.OM.setOnClickListener(new c(this));
        this.OL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, (View.OnClickListener) null);
        this.OL.setOnClickListener(new d(this));
        this.OL.setEnabled(false);
        ((TextView) this.OL.findViewById(com.baidu.tieba.w.save)).setText(com.baidu.tieba.z.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.Pf = (LinearLayout) findViewById(com.baidu.tieba.w.filters);
        this.Pb = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.OX = (LinearLayout) findViewById(com.baidu.tieba.w.beautify_rotate);
        this.OW = (LinearLayout) findViewById(com.baidu.tieba.w.rotate);
        this.OT = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.OV = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        f fVar = new f(this);
        this.OT.setOnCheckedChangeListener(fVar);
        this.OV.setOnCheckedChangeListener(fVar);
        this.OT.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.w.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.w.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.w.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.w.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        g gVar = new g(this);
        button.setOnClickListener(gVar);
        button2.setOnClickListener(gVar);
        button3.setOnClickListener(gVar);
        button4.setOnClickListener(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(String str) {
        if (this.OR != null) {
            this.OR.cancel();
        }
        this.OR = new j(this, null);
        this.OR.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.s.a(null, str, bitmap, 80);
            if (this.Pg) {
                new av("motu_pic", String.valueOf(this.Pc)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String[] strArr) {
        if (this.Ph != null && strArr != null) {
            this.Pf.removeAllViews();
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.w.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.w.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.w.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dG(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new h(this, substring, i2));
                    this.Pj = imageView2;
                } else {
                    imageView2.setOnClickListener(new i(this, substring, i2));
                }
                this.Pf.addView(inflate2);
                if (this.Pi != null) {
                    this.Pi.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            de(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.Pi == null) {
                this.Pi = new HashMap<>();
            }
            if (this.Pe != null && (imageView = this.Pi.get(this.Pe)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.Pb, this.Pb, this.Pb, this.Pb);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.Pi.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.v.round_corner);
                imageView2.setPadding(this.Pb, this.Pb, this.Pb, this.Pb);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.Pe = str;
        }
    }

    private void regReceiver() {
        this.Pa = new n(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.Pa, intentFilter);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
