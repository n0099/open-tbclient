package com.baidu.location;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes.dex */
class a implements b {
    private static Boolean lv = true;
    private static Boolean lq = true;
    private static char lr = 'v';
    private static String ls = "/sdcard/baidu";
    private static int lu = 0;
    private static String lp = "LocLog.txt";
    private static SimpleDateFormat lw = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat lt = new SimpleDateFormat("yyyy-MM-dd");

    a() {
    }

    /* renamed from: byte  reason: not valid java name */
    public static void m53byte(String str, String str2) {
        m61if(str, str2, 'd');
    }

    /* renamed from: case  reason: not valid java name */
    public static void m54case(String str, String str2) {
        m61if(str, str2, 'w');
    }

    /* renamed from: char  reason: not valid java name */
    public static void m55char(String str, String str2) {
        m61if(str, str2, 'i');
    }

    public static void dh() {
        File file = new File(ls, lt.format(di()) + lp);
        if (file.exists()) {
            file.delete();
        }
    }

    private static Date di() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - lu);
        return calendar.getTime();
    }

    /* renamed from: do  reason: not valid java name */
    public static void m56do(String str, Object obj) {
        m61if(str, obj.toString(), 'i');
    }

    /* renamed from: else  reason: not valid java name */
    public static void m57else(String str, String str2) {
        m61if(str, str2, 'v');
    }

    /* renamed from: for  reason: not valid java name */
    public static void m58for(String str, Object obj) {
        m61if(str, obj.toString(), 'v');
    }

    /* renamed from: goto  reason: not valid java name */
    public static void m59goto(String str, String str2) {
        m61if(str, str2, 'e');
    }

    /* renamed from: if  reason: not valid java name */
    public static void m60if(String str, Object obj) {
        m61if(str, obj.toString(), 'w');
    }

    /* renamed from: if  reason: not valid java name */
    private static void m61if(String str, String str2, char c) {
    }

    /* renamed from: int  reason: not valid java name */
    public static void m62int(String str, Object obj) {
        m61if(str, obj.toString(), 'e');
    }

    /* renamed from: int  reason: not valid java name */
    private static void m63int(String str, String str2, String str3) {
        Date date;
        String str4 = lw.format(date) + "    " + str + "    " + str2 + "    " + str3;
        try {
            FileWriter fileWriter = new FileWriter(new File(ls, lt.format(new Date()) + lp), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str4);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
        }
    }

    /* renamed from: new  reason: not valid java name */
    public static void m64new(String str, Object obj) {
        m61if(str, obj.toString(), 'd');
    }
}
