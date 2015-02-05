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
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity<EditHeadActivity> {
    private LinearLayout PD;
    private HashMap<String, Bitmap> PF;
    private HashMap<String, ImageView> PG;
    private View PH;
    private View Pk;
    private View Pl;
    private RadioButton Pr;
    private RadioButton Ps;
    private NavigationBar mNavigationBar;
    private int requestCode;
    public static String Pe = "resourceid";
    public static String Pf = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String Pg = "change";
    public static String FILE_NAME = "file_name";
    private static String[] Ph = null;
    private EditHeadsImageView Pi = null;
    private Bitmap mBitmap = null;
    private int Pj = 0;
    private Button Pm = null;
    private Button Pn = null;
    private HorizontalScrollView Po = null;
    private ProgressBar mProgress = null;
    private m Pp = null;
    private j Pq = null;
    private LinearLayout Pt = null;
    private LinearLayout Pu = null;
    private o Pv = null;
    private TextView mTitle = null;
    private Bitmap Pw = null;
    private n Px = null;
    private int Py = 0;
    private int Pz = 0;
    private boolean PA = true;
    private String PC = null;
    private boolean PE = false;
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
        if (com.baidu.adp.lib.b.f.da().Z("motu_sdk") == 1 || PluginPackageManager.hV().bj(PluginCenter.NAME_MOTUSDK) == PluginPackageManager.PluginStatus.DISABLE) {
            this.PA = false;
        } else {
            this.PA = true;
        }
        TbadkCoreApplication.m255getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.x.edit_head_activity);
        Intent intent = getIntent();
        this.Pj = intent.getIntExtra("edit_type", 0);
        this.requestCode = intent.getIntExtra("request", 0);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), bg.pB().pH());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, bg.pB().pH(), 0, stringExtra);
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        Ph = getResources().getStringArray(com.baidu.tieba.r.fiter_name);
        if (this.PA) {
            TbadkCoreApplication.m255getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.j(this.mNavigationBar, com.baidu.tieba.t.alpha80_black);
        getLayoutMode().h(this.Pk);
        getLayoutMode().h(this.mTitle);
        getLayoutMode().h(this.Pl);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.Pp != null) {
            this.Pp.cancel();
        }
        this.Pi.setImageDrawable(null);
        rd();
    }

    private void rd() {
        if (this.PG != null) {
            for (Map.Entry<String, ImageView> entry : this.PG.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.PG.clear();
            this.PG = null;
        }
        if (this.PF != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.PF.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.PF.clear();
            this.PF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.Pp != null) {
            this.Pp.cancel();
        }
        this.Pp = new m(this, null);
        this.Pp.execute(new Object[0]);
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
        this.Pi.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.Pv != null) {
            this.Pv.cancel();
        }
        if (this.Pw != null && !this.Pw.isRecycled()) {
            this.Pw.recycle();
            this.Pw = null;
        }
        if (this.Pp != null) {
            this.Pp.cancel();
            this.Pp = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 12002 || this.requestCode == 12001) {
            unregisterReceiver(this.Px);
        }
        TbadkCoreApplication.m255getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        if (this.Pv != null) {
            this.Pv.cancel();
        }
        this.Pv = new o(this, null);
        this.Pv.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.w.progress);
        this.mProgress.setVisibility(8);
        this.Pi = (EditHeadsImageView) findViewById(com.baidu.tieba.w.image);
        if (this.mBitmap != null) {
            this.Pi.setImageBitmap(this.mBitmap);
        }
        this.Po = (HorizontalScrollView) findViewById(com.baidu.tieba.w.filters_layout);
        this.Pk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.Pn = (Button) findViewById(com.baidu.tieba.w.show_button);
        this.Pn.setOnClickListener(new b(this));
        this.Pm = (Button) findViewById(com.baidu.tieba.w.hide_button);
        this.Pm.setVisibility(0);
        this.Pm.setOnClickListener(new c(this));
        this.Pl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.image_activity_save_button, (View.OnClickListener) null);
        this.Pl.setOnClickListener(new d(this));
        this.Pl.setEnabled(false);
        ((TextView) this.Pl.findViewById(com.baidu.tieba.w.save)).setText(com.baidu.tieba.z.done);
        this.mTitle = this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.beautify));
        this.PD = (LinearLayout) findViewById(com.baidu.tieba.w.filters);
        this.Py = com.baidu.adp.lib.util.l.dip2px(getPageContext().getPageActivity(), 2.0f);
        this.Pu = (LinearLayout) findViewById(com.baidu.tieba.w.beautify_rotate);
        this.Pt = (LinearLayout) findViewById(com.baidu.tieba.w.rotate);
        this.Pr = (RadioButton) findViewById(com.baidu.tieba.w.beautify_btn);
        this.Ps = (RadioButton) findViewById(com.baidu.tieba.w.rotate_btn);
        f fVar = new f(this);
        this.Pr.setOnCheckedChangeListener(fVar);
        this.Ps.setOnCheckedChangeListener(fVar);
        this.Pr.setChecked(true);
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
    public void cZ(String str) {
        if (this.Pq != null) {
            this.Pq.cancel();
        }
        this.Pq = new j(this, null);
        this.Pq.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.s.a(null, str, bitmap, 80);
            if (this.PE) {
                new ba("motu_pic", String.valueOf(this.Pz)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String[] strArr) {
        if (this.PF != null && strArr != null) {
            this.PD.removeAllViews();
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.w.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getPageActivity(), com.baidu.tieba.x.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.w.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.w.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.dC(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new h(this, substring, i2));
                    this.PH = imageView2;
                } else {
                    imageView2.setOnClickListener(new i(this, substring, i2));
                }
                this.PD.addView(inflate2);
                if (this.PG != null) {
                    this.PG.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            da(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.PG == null) {
                this.PG = new HashMap<>();
            }
            if (this.PC != null && (imageView = this.PG.get(this.PC)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.Py, this.Py, this.Py, this.Py);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.PG.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.v.round_corner);
                imageView2.setPadding(this.Py, this.Py, this.Py, this.Py);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.PC = str;
        }
    }

    private void regReceiver() {
        this.Px = new n(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.Px, intentFilter);
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
